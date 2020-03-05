package io.itcast.cfc.controller;

import com.github.pagehelper.Page;
import io.itcast.cfc.dto.in.OrderCheckoutInDTO;
import io.itcast.cfc.dto.out.OrderListOutDTO;
import io.itcast.cfc.dto.out.OrderShowOutDTO;
import io.itcast.cfc.dto.out.PageOutDTO;
import io.itcast.cfc.model.Order;
import io.itcast.cfc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/checkout")
    public Long checkout(@RequestBody OrderCheckoutInDTO orderCheckoutInDTO,
                            @RequestAttribute Integer customerId){
        Long orderId = orderService.checkout(orderCheckoutInDTO,customerId);
        return orderId;
    }

    @GetMapping("/getList")
    public PageOutDTO<OrderListOutDTO> getList(@RequestParam(required = false,defaultValue = "1") Integer pageNum,@RequestAttribute Integer customerId){
        Page<Order> orders = orderService.getByCustomerId(pageNum,customerId);
        List<OrderListOutDTO> orderListOutDTOList = orders.stream().map(order -> {
            OrderListOutDTO orderListOutDTO = new OrderListOutDTO();
            orderListOutDTO.setOrderId(order.getOrderId());
            orderListOutDTO.setStatus(order.getStatus());
            orderListOutDTO.setTotalPrice(order.getTotalPrice());
            orderListOutDTO.setCreateTimestamp(order.getCreateTime().getTime());
            return orderListOutDTO;
        }).collect(Collectors.toList());
        PageOutDTO<OrderListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(orders.getTotal());
        pageOutDTO.setPageNum(orders.getPageNum());
        pageOutDTO.setPageSize(orders.getPageSize());
        pageOutDTO.setList(orderListOutDTOList);
        return pageOutDTO;
    }

    @GetMapping("/getById")
    public OrderShowOutDTO getById(@RequestParam Long orderId){
        OrderShowOutDTO orderShowOutDTO = orderService.getById(orderId);
        return orderShowOutDTO;
    }
}