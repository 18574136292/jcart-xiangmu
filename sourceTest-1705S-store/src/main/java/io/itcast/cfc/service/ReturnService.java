package io.itcast.cfc.service;

import com.github.pagehelper.Page;
import io.itcast.cfc.model.Return;

public interface ReturnService {
    Integer create(Return returnOne);

    Page<Return> getByCustomerId(Integer customerId, Integer pageNum);

    Return getById(Integer returnId);
}
