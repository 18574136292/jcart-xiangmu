package io.itcast.cfc.service.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import io.itcast.cfc.dao.CustomerMapper;
import io.itcast.cfc.dto.in.CustomerRegisterInDTO;
import io.itcast.cfc.enumeration.CustomerStatus;
import io.itcast.cfc.model.Customer;
import io.itcast.cfc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Integer register(CustomerRegisterInDTO customerRegisterInDTO) {
        Customer customer = new Customer();
        customer.setUsername(customerRegisterInDTO.getUsername());
        customer.setRealName(customerRegisterInDTO.getRealName());
        customer.setEmail(customerRegisterInDTO.getEmail());
        customer.setEmailVerified(false);
        customer.setMobile(customerRegisterInDTO.getMobile());
        customer.setMobileVerified(false);
        customer.setNewsSubscribed(customerRegisterInDTO.getNewsSubscribed());
        customer.setCreateTime(new Date());
        customer.setStatus((byte) CustomerStatus.Enable.ordinal());
        customer.setRewordPoints(0);
        String bcryptPassword = BCrypt.withDefaults().hashToString(12, customerRegisterInDTO.getPassword().toCharArray());
        customer.setEncryptedPassword(bcryptPassword);

        customerMapper.insertSelective(customer);
        return customer.getCustomerId();
    }

    @Override
    public Customer getByUsername(String username) {
        return customerMapper.selectByUsername(username);
    }

    @Override
    public Customer getById(Integer customerId) {
        return customerMapper.selectByPrimaryKey(customerId);
    }

    @Override
    public void update(Customer customer) {
        customerMapper.updateByPrimaryKeySelective(customer);
    }

    @Override
    public Customer getByEmail(String email) {
        return customerMapper.selectByEmail(email);
    }
}
