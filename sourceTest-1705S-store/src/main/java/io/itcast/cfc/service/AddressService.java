package io.itcast.cfc.service;

import io.itcast.cfc.model.Address;

import java.util.List;

public interface AddressService {
    List<Address> getByCustomerId(Integer customerId);

    Integer create(Address address);

    void update(Address address);

    void delete(Integer addressId);

    Address getById(Integer addressId);
}
