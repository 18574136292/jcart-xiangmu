package io.itcast.cfc.dao;

import com.github.pagehelper.Page;
import io.itcast.cfc.dto.out.ProductListOutDTO;
import io.itcast.cfc.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    Page<ProductListOutDTO> search();

    void batchDelete(List<Integer> productIds);
}