package io.itcast.cfc.service.impl;

import io.itcast.cfc.dao.AdministratorMapper;
import io.itcast.cfc.model.Administrator;
import io.itcast.cfc.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorMapper administratorMapper;

    @Override
    public Administrator getByUsername(String username) {

        Administrator administrator = administratorMapper.selectByUsername(username);
        return administrator;
    }
}
