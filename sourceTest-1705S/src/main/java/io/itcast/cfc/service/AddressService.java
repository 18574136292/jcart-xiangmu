package io.itcast.cfc.service;

import io.itcast.cfc.model.Address;

import java.util.List;

public interface AddressService {
    Address getById(Integer defaultAddressId);

    List<Address> getListByCustomerId(Integer customerId);
}
