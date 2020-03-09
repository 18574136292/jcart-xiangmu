package io.itcast.cfc.dao;

import com.github.pagehelper.Page;
import io.itcast.cfc.model.Return;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ReturnMapper {
    int deleteByPrimaryKey(Integer returnId);

    int insert(Return record);

    int insertSelective(Return record);

    Return selectByPrimaryKey(Integer returnId);

    int updateByPrimaryKeySelective(Return record);

    int updateByPrimaryKey(Return record);

    Page<Return> pageSearch(@Param("returnId")Integer returnId,
                            @Param("orderId") Long orderId,
                            @Param("startTime") Date startTime,
                            @Param("endTime") Date endTime,
                            @Param("status") Byte status,
                            @Param("productCode") String productCode,
                            @Param("productName") String productName,
                            @Param("customerName") String customerName);
}