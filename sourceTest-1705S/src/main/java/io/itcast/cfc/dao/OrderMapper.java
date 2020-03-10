package io.itcast.cfc.dao;

import com.github.pagehelper.Page;
import io.itcast.cfc.dto.out.OrderListOutDTO;
import io.itcast.cfc.model.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    Page<OrderListOutDTO> pageSearch(@Param("orderId") Long orderId,
                                     @Param("status") Byte status,
                                     @Param("totalPrice") Double totalPrice,
                                     @Param("customerName") String customerName,
                                     @Param("startTime") Date startTime,
                                     @Param("endTime") Date endTime);
}