package io.itcast.cfc.service;

import com.github.pagehelper.Page;
import io.itcast.cfc.dto.in.ReturnSearchInDTO;
import io.itcast.cfc.model.Return;

public interface ReturnService {
    void update(Return returnOne);

    Page<Return> pageSearch(Integer pageNum, ReturnSearchInDTO returnSearchInDTO);

    Return getById(Integer returnId);
}
