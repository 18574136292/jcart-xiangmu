package io.itcast.cfc.dao;

import com.github.pagehelper.Page;
import io.itcast.cfc.model.Administrator;

import java.util.List;

public interface AdministratorMapper {
    int deleteByPrimaryKey(Integer administratorId);

    int insert(Administrator record);

    int insertSelective(Administrator record);

    Administrator selectByPrimaryKey(Integer administratorId);

    int updateByPrimaryKeySelective(Administrator record);

    int updateByPrimaryKey(Administrator record);

    Administrator selectByUsername(String username);

    void deleteAny(List<Integer> administratorIds);

    Page<Administrator> selectListAll();
}