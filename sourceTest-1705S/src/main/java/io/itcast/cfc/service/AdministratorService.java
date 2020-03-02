package io.itcast.cfc.service;

import io.itcast.cfc.model.Administrator;

public interface AdministratorService {
    Administrator getByUsername(String username);

    Administrator getById(Integer administratorId);

    void update(Administrator administrator);

    Integer create(Administrator administrator);
}
