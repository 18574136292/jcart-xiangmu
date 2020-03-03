package io.itcast.cfc.dao;

import io.itcast.cfc.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMapper {
    int deleteByPrimaryKey(Integer customerId);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer customerId);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    Customer selectByUsername(String username);
}