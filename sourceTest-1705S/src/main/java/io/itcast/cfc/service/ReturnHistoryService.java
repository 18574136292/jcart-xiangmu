package io.itcast.cfc.service;

import io.itcast.cfc.model.ReturnHistory;

import java.util.List;

public interface ReturnHistoryService {
    List<ReturnHistory> getListByReturnId(Integer returnId);

    Integer create(ReturnHistory returnHistory);
}
