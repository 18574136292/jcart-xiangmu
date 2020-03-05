package io.itcast.cfc.dao;

import com.github.pagehelper.Page;
import io.itcast.cfc.model.Administrator;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
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