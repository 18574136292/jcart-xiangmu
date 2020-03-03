package io.itcast.cfc.service;

import com.github.pagehelper.Page;
import io.itcast.cfc.dto.out.ProductListOutDTO;
import io.itcast.cfc.dto.out.ProductShowOutDTO;

public interface ProductService {
    Page<ProductListOutDTO> selectAllProduct(Integer pageNum);

    ProductShowOutDTO getById(Integer productId);
}
