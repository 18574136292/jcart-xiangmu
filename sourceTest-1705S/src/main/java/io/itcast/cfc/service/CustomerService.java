package io.itcast.cfc.service;

import com.github.pagehelper.Page;
import io.itcast.cfc.dto.in.CustomerSearchInDTO;
import io.itcast.cfc.dto.in.CustomerSetStatusInDTO;
import io.itcast.cfc.model.Customer;

public interface CustomerService {
    Page<Customer> pageSearch(Integer pageNum, CustomerSearchInDTO customerSearchInDTO);

    void setStatus(CustomerSetStatusInDTO customerSetStatusInDTO);

    Customer getById(Integer customerId);
}
