package io.itcast.cfc.controller;

import com.github.pagehelper.Page;
import io.itcast.cfc.dto.in.CustomerSearchInDTO;
import io.itcast.cfc.dto.out.CustomerLIstOutDTO;
import io.itcast.cfc.dto.out.CustomerShowOutDTO;
import io.itcast.cfc.dto.out.PageOutDTO;
import io.itcast.cfc.model.Customer;
import io.itcast.cfc.service.AddressService;
import io.itcast.cfc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AddressService addressService;

    @GetMapping("/pageSearch")
    public PageOutDTO<CustomerLIstOutDTO> pageSearch(CustomerSearchInDTO customerSearchInDTO, @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        Page<Customer> page = customerService.pageSearch(pageNum);
        List<CustomerLIstOutDTO> customerLIstOutDTOS = page.stream().map(p -> {
            CustomerLIstOutDTO customerLIstOutDTO = new CustomerLIstOutDTO();
            customerLIstOutDTO.setCustomerId(p.getCustomerId());
            customerLIstOutDTO.setUsername(p.getUsername());
            customerLIstOutDTO.setRealName(p.getRealName());
            customerLIstOutDTO.setMobile(p.getMobile());
            customerLIstOutDTO.setEmail(p.getEmail());
            customerLIstOutDTO.setStatus(p.getStatus());
            customerLIstOutDTO.setCreateTimestamp(p.getCreateTime().getTime());
            return customerLIstOutDTO;
        }).collect(Collectors.toList());
        PageOutDTO<CustomerLIstOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setList(customerLIstOutDTOS);
        return pageOutDTO;
    }

    @GetMapping("/getById")
    public CustomerShowOutDTO getById(@RequestParam Integer customerId){
        return null;
    }

    @PostMapping("/disable")
    public void disable(@RequestParam Integer customerId){

    }
}
