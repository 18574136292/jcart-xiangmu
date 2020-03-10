package io.itcast.cfc.controller;

import com.github.pagehelper.Page;
import io.itcast.cfc.dto.in.ProductCreateInDTO;
import io.itcast.cfc.dto.in.ProductSearchInDTO;
import io.itcast.cfc.dto.in.ProductUpdateInDTO;
import io.itcast.cfc.dto.out.PageOutDTO;
import io.itcast.cfc.dto.out.ProductListOutDTO;
import io.itcast.cfc.dto.out.ProductShowOutDTO;
import io.itcast.cfc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/pageSearch")
    public PageOutDTO<ProductListOutDTO> pageSearch(ProductSearchInDTO productSearchInDTO, @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        Page<ProductListOutDTO> page = productService.search(pageNum,productSearchInDTO);
        PageOutDTO<ProductListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setList(page);

        return pageOutDTO;
    }

    @GetMapping("/getById")
    public ProductShowOutDTO getById(@RequestParam Integer productId){
        ProductShowOutDTO productShowOutDTO = productService.getById(productId);
        return productShowOutDTO;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody ProductCreateInDTO productCreateInDTO){
        Integer productId = productService.create(productCreateInDTO);
        return productId;
    }
    @PostMapping("/update")
    public void update(@RequestBody ProductUpdateInDTO productUpdateInDTO){
        productService.update(productUpdateInDTO);
    }

    @PostMapping("/delete")
    public void update(@RequestBody Integer productId){
        productService.delete(productId);
    }

    @PostMapping("/batchDelete")
    public void batchDelete(@RequestBody List<Integer> productIds){
        productService.batchDelete(productIds);
    }
}
