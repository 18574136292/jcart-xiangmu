package io.itcast.cfc.service;

import com.github.pagehelper.Page;
import io.itcast.cfc.dto.out.OrderListOutDTO;
import io.itcast.cfc.dto.out.OrderShowOutDTO;

public interface OrderService {
    Page<OrderListOutDTO> pageSearch(Integer pageNum);

    OrderShowOutDTO getById(Long orderId);
}
