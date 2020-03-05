package io.itcast.cfc.controller;

import com.github.pagehelper.Page;
import io.itcast.cfc.dto.out.*;
import io.itcast.cfc.dto.in.OrderSearchInDTO;
import io.itcast.cfc.dto.out.*;
import io.itcast.cfc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/pageSearch")
    public PageOutDTO<OrderListOutDTO> pageSearch(OrderSearchInDTO orderSearchInDTO,
                                                  @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        Page<OrderListOutDTO> orderListOutDTOS = orderService.pageSearch(pageNum);
        PageOutDTO<OrderListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(orderListOutDTOS.getTotal());
        pageOutDTO.setPageNum(orderListOutDTOS.getPageNum());
        pageOutDTO.setPageSize(orderListOutDTOS.getPageSize());
        pageOutDTO.setList(orderListOutDTOS);
        return pageOutDTO;
    }

    @GetMapping("/getById")
    public OrderShowOutDTO getById(@RequestParam Long orderId){
        OrderShowOutDTO orderShowOutDTO = orderService.getById(orderId);
        return orderShowOutDTO;
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
