package io.itcast.cfc.service;

import com.github.pagehelper.Page;
import io.itcast.cfc.dto.in.OrderSearchInDTO;
import io.itcast.cfc.dto.out.OrderListOutDTO;
import io.itcast.cfc.dto.out.OrderShowOutDTO;
import io.itcast.cfc.model.Order;

public interface OrderService {
    Page<OrderListOutDTO> pageSearch(Integer pageNum, OrderSearchInDTO orderSearchInDTO);

    OrderShowOutDTO getById(Long orderId);

    void update(Order order);
}
