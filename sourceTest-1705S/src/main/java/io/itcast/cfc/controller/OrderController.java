package io.itcast.cfc.controller;

import io.itcast.cfc.dto.out.*;
import io.itcast.cfc.dto.in.OrderSearchInDTO;
import io.itcast.cfc.dto.out.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/pageSearch")
    public PageOutDTO<OrderListOutDTO> pageSearch(OrderSearchInDTO orderSearchInDTO, @RequestParam Integer pageNum){
        return null;
    }

    @GetMapping("/getById")
    public OrderShowOutDTO getById(@RequestParam Long orderId){
        return null;
    }

    @GetMapping("/getInvoiceInfo")
    public OrderInvoiceShowOutDTO getInvoiceInfo(@RequestParam Long orderId){
        return null;
    }

    @GetMapping("/getShipInfo")
    public OrderShipShowOutDTO getShipInfo(@RequestParam Long orderId){
        return null;
    }
}
