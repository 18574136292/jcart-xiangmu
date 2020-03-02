package io.itcast.cfc.service;

import com.github.pagehelper.Page;
import io.itcast.cfc.model.Administrator;

import java.util.List;

public interface AdministratorService {
    Administrator getByUsername(String username);

    Administrator getById(Integer administratorId);

    void update(Administrator administrator);

    Integer create(Administrator administrator);

    void delete(Integer administratorId);

    void deleteAny(List<Integer> administratorIds);

    Page<Administrator> getList(Integer pageNum);
}
