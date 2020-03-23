package io.itcast.cfc.service;

import io.itcast.cfc.model.ProductOperation;

import java.util.List;

public interface ProductOperationService {
    List<ProductOperation> selectHotProduct();

    void count(Integer productId);
}
