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

    @Override
    public Administrator getById(Integer administratorId) {
        Administrator administrator = administratorMapper.selectByPrimaryKey(administratorId);
        return administrator;
    }

    @Override
    public void update(Administrator administrator) {
        administratorMapper.updateByPrimaryKeySelective(administrator);
    }

    @Override
    public Integer create(Administrator administrator) {
        administratorMapper.insertSelective(administrator);
        return administrator.getAdministratorId();
    }
}
