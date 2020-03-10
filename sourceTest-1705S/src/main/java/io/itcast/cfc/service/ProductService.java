package io.itcast.cfc.service;

import com.github.pagehelper.Page;
import io.itcast.cfc.dto.in.ProductCreateInDTO;
import io.itcast.cfc.dto.in.ProductSearchInDTO;
import io.itcast.cfc.dto.in.ProductUpdateInDTO;
import io.itcast.cfc.dto.out.ProductListOutDTO;
import io.itcast.cfc.dto.out.ProductShowOutDTO;

import java.util.List;

public interface ProductService {
    Page<ProductListOutDTO> search(Integer pageNum, ProductSearchInDTO productSearchInDTO);

    Integer create(ProductCreateInDTO productCreateInDTO);

    ProductShowOutDTO getById(Integer productId);

    void update(ProductUpdateInDTO productUpdateInDTO);

    void delete(Integer productId);

    void batchDelete(List<Integer> productIds);
}
