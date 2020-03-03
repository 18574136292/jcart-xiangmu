package io.itcast.cfc.service;

import io.itcast.cfc.dto.in.CustomerRegisterInDTO;

public interface CustomerService {
    Integer register(CustomerRegisterInDTO customerRegisterInDTO);
}
