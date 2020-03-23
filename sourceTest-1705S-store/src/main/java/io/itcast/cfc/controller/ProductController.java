package io.itcast.cfc.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import io.itcast.cfc.dto.in.ProductSearchInDTO;
import io.itcast.cfc.dto.out.PageOutDTO;
import io.itcast.cfc.dto.out.ProductListOutDTO;
import io.itcast.cfc.dto.out.ProductShowOutDTO;
import io.itcast.cfc.model.ProductOperation;
import io.itcast.cfc.mq.HotProductDTO;
import io.itcast.cfc.service.ProductOperationService;
import io.itcast.cfc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductOperationService productOperationService;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/search")
    public PageOutDTO<ProductListOutDTO> search(ProductSearchInDTO productSearchInDTO,
                                                @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        Page<ProductListOutDTO> productListOutDTOS = productService.selectAllProduct(pageNum);
        PageOutDTO<ProductListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(productListOutDTOS.getTotal());
        pageOutDTO.setPageSize(productListOutDTOS.getPageSize());
        pageOutDTO.setPageNum(productListOutDTOS.getPageNum());
        pageOutDTO.setList(productListOutDTOS);
        return pageOutDTO;
    }

    @GetMapping("/getById")
    public ProductShowOutDTO getById(@RequestParam Integer productId){
        ProductShowOutDTO productShowOutDTO = productService.getById(productId);

        HotProductDTO hotProductDTO = new HotProductDTO();
        hotProductDTO.setProductId(productId);
        hotProductDTO.setProductCode(productShowOutDTO.getProductCode());
        kafkaTemplate.send("jcarttest", JSON.toJSONString(hotProductDTO));
        return productShowOutDTO;
    }

    @GetMapping("/hotProduct")
    public List<ProductOperation> hot(){

        String hotProductsJson = redisTemplate.opsForValue().get("HotProduct");
        if (hotProductsJson != null){
            List<ProductOperation> productOperations = JSON.parseArray(hotProductsJson, ProductOperation.class);
            return productOperations;
        }else {
            List<ProductOperation> hotProducts = productOperationService.selectHotProduct();
            redisTemplate.opsForValue().set("HotProduct", JSON.toJSONString(hotProducts));
            return hotProducts;
        }
    }
}