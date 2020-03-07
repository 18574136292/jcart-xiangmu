package io.itcast.cfc.service.impl;

import io.itcast.cfc.dao.ReturnHistoryMapper;
import io.itcast.cfc.model.Return;
import io.itcast.cfc.model.ReturnHistory;
import io.itcast.cfc.service.ReturnHistoryService;
import io.itcast.cfc.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ReturnHistoryServiceImpl implements ReturnHistoryService {

    @Autowired
    private ReturnHistoryMapper returnHistoryMapper;

    @Autowired
    private ReturnService returnService;

    @Override
    public List<ReturnHistory> getListByReturnId(Integer returnId) {
        return returnHistoryMapper.getListByReturnId(returnId);
    }

    @Override
    @Transactional
    public Integer create(ReturnHistory returnHistory) {
        returnHistoryMapper.insertSelective(returnHistory);
        Return returnOne = new Return();
        returnOne.setReturnId(returnHistory.getReturnId());
        returnOne.setUpdateTime(new Date());
        returnService.update(returnOne);
        return returnHistory.getReturnId();
    }
}
