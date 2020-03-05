package io.itcast.cfc.service.impl;

import io.itcast.cfc.dao.AddressMapper;
import io.itcast.cfc.model.Address;
import io.itcast.cfc.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public Address getById(Integer defaultAddressId) {
        return addressMapper.selectByPrimaryKey(defaultAddressId);
    }
}
