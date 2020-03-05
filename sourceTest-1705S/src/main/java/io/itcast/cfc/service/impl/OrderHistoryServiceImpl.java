package io.itcast.cfc.service.impl;

import io.itcast.cfc.dao.OrderHistoryMapper;
import io.itcast.cfc.model.OrderHistory;
import io.itcast.cfc.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {

    @Autowired
    private OrderHistoryMapper orderHistoryMapper;

    @Override
    public Long create(OrderHistory orderHistory) {
        orderHistoryMapper.insertSelective(orderHistory);
        System.out.println(orderHistory.getOrderHistoryId());
        return orderHistory.getOrderHistoryId();
    }

    @Override
    public List<OrderHistory> getListByOrderId(Long orderId) {
        List<OrderHistory> orderHistoryList = orderHistoryMapper.getListByOrderId(orderId);
        return orderHistoryList;
    }
}
