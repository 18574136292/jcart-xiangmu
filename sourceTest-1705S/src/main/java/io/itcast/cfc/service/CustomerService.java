package io.itcast.cfc.service;

import com.github.pagehelper.Page;
import io.itcast.cfc.model.Customer;

public interface CustomerService {
    Page<Customer> pageSearch(Integer pageNum);
}
