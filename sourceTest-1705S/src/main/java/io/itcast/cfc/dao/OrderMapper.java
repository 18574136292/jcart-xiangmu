package io.itcast.cfc.dao;

import com.github.pagehelper.Page;
import io.itcast.cfc.dto.out.OrderListOutDTO;
import io.itcast.cfc.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    Page<OrderListOutDTO> pageSearch();
}