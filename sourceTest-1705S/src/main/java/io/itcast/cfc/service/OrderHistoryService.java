package io.itcast.cfc.service;

import io.itcast.cfc.model.OrderHistory;

import java.util.List;

public interface OrderHistoryService {
    Long create(OrderHistory orderHistory);

    List<OrderHistory> getListByOrderId(Long orderId);
}
