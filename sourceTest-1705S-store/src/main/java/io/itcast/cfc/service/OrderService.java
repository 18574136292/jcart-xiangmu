package io.itcast.cfc.service;

import com.github.pagehelper.Page;
import io.itcast.cfc.dto.in.OrderCheckoutInDTO;
import io.itcast.cfc.dto.out.OrderShowOutDTO;
import io.itcast.cfc.model.Order;

public interface OrderService {
    Long checkout(OrderCheckoutInDTO orderCheckoutInDTO, Integer customerId);

    Page<Order> getByCustomerId(Integer pageNum, Integer customerId);

    OrderShowOutDTO getById(Long orderId);
}
