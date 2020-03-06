package io.itcast.cfc.service.impl;

import io.itcast.cfc.dao.ReturnHistoryMapper;
import io.itcast.cfc.model.ReturnHistory;
import io.itcast.cfc.service.ReturnHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnHistoryServiceImpl implements ReturnHistoryService {

    @Autowired
    private ReturnHistoryMapper returnHistoryMapper;

    @Override
    public List<ReturnHistory> getHistoryByReturnId(Integer returnId) {
        return returnHistoryMapper.getHistoryByReturnId(returnId);
    }
}
