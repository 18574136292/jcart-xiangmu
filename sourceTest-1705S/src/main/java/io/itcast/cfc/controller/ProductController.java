package io.itcast.cfc.controller;

import io.itcast.cfc.dto.in.ProductCreateInDTO;
import io.itcast.cfc.dto.in.ProductSearchInDTO;
import io.itcast.cfc.dto.in.ProductUpdateInDTO;
import io.itcast.cfc.dto.out.PageOutDTO;
import io.itcast.cfc.dto.out.ProductListOutDTO;
import io.itcast.cfc.dto.out.ProductShowOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/pageSearch")
    public PageOutDTO<ProductListOutDTO> pageSearch(ProductSearchInDTO productSearchInDTO, @RequestParam Integer pageNum){
        return null;
    }

    @GetMapping("/getById")
    public ProductShowOutDTO getById(@RequestParam Integer productId){
        return null;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody ProductCreateInDTO productCreateInDTO){
        return null;
    }
    @PostMapping("/update")
    public void update(@RequestBody ProductUpdateInDTO productUpdateInDTO){

    }

    @PostMapping("/delete")
    public void update(@RequestBody Integer productId){

    }
}
