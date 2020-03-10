package io.itcast.cfc.dao;

import com.github.pagehelper.Page;
import io.itcast.cfc.model.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMapper {
    int deleteByPrimaryKey(Integer customerId);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer customerId);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    Page<Customer> pageSearch(@Param("username") String username,
                              @Param("realName") String realName,
                              @Param("mobile") String mobile,
                              @Param("email") String email,
                              @Param("status") Byte status);
}