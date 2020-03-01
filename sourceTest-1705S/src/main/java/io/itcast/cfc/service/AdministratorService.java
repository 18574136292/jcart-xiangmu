package io.itcast.cfc.service;

import io.itcast.cfc.model.Administrator;

public interface AdministratorService {
    Administrator getByUsername(String username);
}
