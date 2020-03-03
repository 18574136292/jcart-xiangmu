package io.itcast.cfc.service;

import io.itcast.cfc.dto.in.CustomerRegisterInDTO;
import io.itcast.cfc.model.Customer;

public interface CustomerService {
    Integer register(CustomerRegisterInDTO customerRegisterInDTO);

    Customer getByUsername(String username);

    Customer getById(Integer customerId);

    void update(Customer customer);

    Customer getByEmail(String email);
}
