package io.itcast.cfc.controller;

import io.itcast.cfc.dto.in.CustomerSearchInDTO;
import io.itcast.cfc.dto.out.CustomerLIstOutDTO;
import io.itcast.cfc.dto.out.CustomerShowOutDTO;
import io.itcast.cfc.dto.out.PageOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("/pageSearch")
    public PageOutDTO<CustomerLIstOutDTO> pageSearch(CustomerSearchInDTO customerSearchInDTO, @RequestParam Integer pageNum){
        return null;
    }

    @GetMapping("/getById")
    public CustomerShowOutDTO getById(@RequestParam Integer customerId){
        return null;
    }

    @PostMapping("/disable")
    public void disable(@RequestParam Integer customerId){
        
    }
}
