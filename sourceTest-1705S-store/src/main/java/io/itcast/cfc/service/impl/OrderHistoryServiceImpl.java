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
    public List<OrderHistory> getByOrderId(Long orderId) {
        List<OrderHistory> orderHistoryList = orderHistoryMapper.selectByOrderId(orderId);
        return orderHistoryList;
    }
}
