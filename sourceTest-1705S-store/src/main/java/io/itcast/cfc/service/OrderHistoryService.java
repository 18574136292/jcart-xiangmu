package io.itcast.cfc.service;

import io.itcast.cfc.model.OrderHistory;

import java.util.List;

public interface OrderHistoryService {

    List<OrderHistory> getByOrderId(Long orderId);
}
