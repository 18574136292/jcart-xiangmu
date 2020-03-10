package io.itcast.cfc.dao;

import com.github.pagehelper.Page;
import io.itcast.cfc.dto.out.ProductListOutDTO;
import io.itcast.cfc.model.Product;
import org.apache.ibatis.annotations.Param;
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

    Page<ProductListOutDTO> search(
            @Param("productCode") String productCode,
            @Param("status") Byte status,
            @Param("stockQuantity") Integer stockQuantity,
            @Param("price") Double price,
            @Param("productName")String productName);

    void batchDelete(@Param("productIds") List<Integer> productIds);
}