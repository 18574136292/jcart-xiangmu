package io.itcast.cfc.service.impl;

import io.itcast.cfc.dao.AddressMapper;
import io.itcast.cfc.model.Address;
import io.itcast.cfc.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public Address getById(Integer defaultAddressId) {
        return addressMapper.selectByPrimaryKey(defaultAddressId);
    }

    @Override
    public List<Address> getListByCustomerId(Integer customerId) {
        return addressMapper.selectByCustomerId(customerId);
    }
}
