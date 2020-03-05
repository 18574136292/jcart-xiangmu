package io.itcast.cfc.service;

import io.itcast.cfc.model.Address;

public interface AddressService {
    Address getById(Integer defaultAddressId);
}
