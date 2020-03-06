package io.itcast.cfc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.itcast.cfc.dao.ReturnMapper;
import io.itcast.cfc.model.Return;
import io.itcast.cfc.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReturnServiceImpl implements ReturnService {

    @Autowired
    private ReturnMapper returnMapper;

    @Override
    public Integer create(Return returnOne) {
        returnMapper.insertSelective(returnOne);
        return returnOne.getReturnId();
    }

    @Override
    public Page<Return> getByCustomerId(Integer customerId, Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        Page<Return> page = returnMapper.getByCustomerId(customerId);
        return page;
    }

    @Override
    public Return getById(Integer returnId) {
        return returnMapper.selectByPrimaryKey(returnId);
    }
}
