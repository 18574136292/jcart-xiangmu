package io.itcast.cfc.dao;

import com.github.pagehelper.Page;
import io.itcast.cfc.model.Return;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnMapper {
    int deleteByPrimaryKey(Integer returnId);

    int insert(Return record);

    int insertSelective(Return record);

    Return selectByPrimaryKey(Integer returnId);

    int updateByPrimaryKeySelective(Return record);

    int updateByPrimaryKey(Return record);

    Page<Return> getByCustomerId(Integer customerId);
}