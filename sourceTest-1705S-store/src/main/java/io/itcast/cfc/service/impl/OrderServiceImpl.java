package io.itcast.cfc.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.itcast.cfc.dao.OrderDetailMapper;
import io.itcast.cfc.dao.OrderMapper;
import io.itcast.cfc.dto.in.OrderCheckoutInDTO;
import io.itcast.cfc.dto.in.OrderProductInDTO;
import io.itcast.cfc.dto.out.OrderHistoryListOutDTO;
import io.itcast.cfc.dto.out.OrderShowOutDTO;
import io.itcast.cfc.dto.out.ProductShowOutDTO;
import io.itcast.cfc.enumeration.OrderStatus;
import io.itcast.cfc.model.Order;
import io.itcast.cfc.model.OrderDetail;
import io.itcast.cfc.model.OrderHistory;
import io.itcast.cfc.model.Product;
import io.itcast.cfc.service.AddressService;
import io.itcast.cfc.service.OrderHistoryService;
import io.itcast.cfc.service.OrderService;
import io.itcast.cfc.service.ProductService;
import io.itcast.cfc.vo.OrderProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private ProductService productService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private OrderHistoryService orderHistoryService;

    @Override
    @Transactional
    public Long checkout(OrderCheckoutInDTO orderCheckoutInDTO, Integer customerId) {
        List<OrderProductInDTO> orderProductList = orderCheckoutInDTO.getOrderProducts();
        List<OrderProductVO> orderProductVOS = orderProductList.stream().map(o -> {
            Product product = productService.selectById(o.getProductId());
            OrderProductVO orderProductVO = new OrderProductVO();
            orderProductVO.setProductId(product.getProductId());
            orderProductVO.setProductCode(product.getProductCode());
            orderProductVO.setProductName(product.getProductName());
            orderProductVO.setQuantity(o.getQuantity());
            Double unitPrice = product.getPrice() * product.getDiscount();
            orderProductVO.setUnitPrice(unitPrice);
            orderProductVO.setTotalPrice(unitPrice * o.getQuantity());
            orderProductVO.setUnitRewordPoints(product.getRewordPoints());
            orderProductVO.setTotalRewordPoints(product.getRewordPoints() * o.getQuantity());
            return orderProductVO;
        }).collect(Collectors.toList());
        double totalPriceAll = orderProductVOS.stream().mapToDouble(p -> p.getTotalPrice()).sum();
        int totalRewordPointsAll = orderProductVOS.stream().mapToInt(p -> p.getTotalRewordPoints()).sum();

        Order order = new Order();
        order.setCustomerId(customerId);
        order.setStatus((byte) OrderStatus.ToProcess.ordinal());
        order.setTotalPrice(totalPriceAll);
        order.setRewordPoints(totalRewordPointsAll);
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        orderMapper.insertSelective(order);

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(order.getOrderId());
        orderDetail.setShipMethod(orderCheckoutInDTO.getShipMethod());
        orderDetail.setShipPrice(8.0);
        orderDetail.setShipAddress(addressService.getById(orderCheckoutInDTO.getShipAddressId()).getContent());
        orderDetail.setPayMethod(orderCheckoutInDTO.getPayMethod());
        orderDetail.setInvoicePrice(totalPriceAll);
        orderDetail.setInvoiceAddress(addressService.getById(orderCheckoutInDTO.getInvoiceAddressId()).getContent());
        orderDetail.setComment(orderCheckoutInDTO.getComment());
        orderDetail.setOrderProducts(JSON.toJSONString(orderProductVOS));
        orderDetailMapper.insertSelective(orderDetail);

        return order.getOrderId();
    }

    @Override
    public Page<Order> getByCustomerId(Integer pageNum, Integer customerId) {
        PageHelper.startPage(pageNum,10);
        Page<Order> page = orderMapper.getByCustomerId(customerId);
        return page;
    }

    @Override
    public OrderShowOutDTO getById(Long orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        OrderDetail orderDetail = orderDetailMapper.selectByPrimaryKey(orderId);

        OrderShowOutDTO orderShowOutDTO = new OrderShowOutDTO();
        orderShowOutDTO.setOrderId(orderId);
        orderShowOutDTO.setStatus(order.getStatus());
        orderShowOutDTO.setTotalPrice(order.getTotalPrice());
        orderShowOutDTO.setRewordPoints(order.getRewordPoints());
        orderShowOutDTO.setCreateTimestamp(order.getCreateTime().getTime());
        orderShowOutDTO.setUpdateTimestamp(order.getUpdateTime().getTime());
        orderShowOutDTO.setShipAddress(orderDetail.getShipAddress());
        orderShowOutDTO.setShipMethod(orderDetail.getShipMethod());
        orderShowOutDTO.setShipPrice(orderDetail.getShipPrice());
        orderShowOutDTO.setPayMethod(orderDetail.getPayMethod());
        orderShowOutDTO.setInvoiceAddress(orderDetail.getInvoiceAddress());
        orderShowOutDTO.setInvoicePrice(orderDetail.getInvoicePrice());
        orderShowOutDTO.setComment(orderDetail.getComment());

        List<OrderProductVO> orderProductVOS = JSON.parseArray(orderDetail.getOrderProducts(), OrderProductVO.class);
        orderShowOutDTO.setOrderProducts(orderProductVOS);

        List<OrderHistory> orderHistoryList = orderHistoryService.getByOrderId(orderId);
        List<OrderHistoryListOutDTO> orderHistoryListOutDTOS = orderHistoryList.stream().map(ol -> {
            OrderHistoryListOutDTO orderHistoryListOutDTO = new OrderHistoryListOutDTO();
            orderHistoryListOutDTO.setTimestamp(ol.getTime().getTime());
            orderHistoryListOutDTO.setOrderStatus(ol.getOrderStatus());
            orderHistoryListOutDTO.setComment(ol.getComment());
            return orderHistoryListOutDTO;
        }).collect(Collectors.toList());

        orderShowOutDTO.setOrderHistories(orderHistoryListOutDTOS);
        return orderShowOutDTO;
    }
}
