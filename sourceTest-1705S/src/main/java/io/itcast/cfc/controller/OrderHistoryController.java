package io.itcast.cfc.controller;

import io.itcast.cfc.dto.in.OrderHistoryCreateInDTO;
import io.itcast.cfc.dto.out.OrderHistoryListOutDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderHistory")
public class OrderHistoryController {

    @GetMapping("/getListByOrderId")
    public List<OrderHistoryListOutDTO> getListByOrderId(@RequestParam Long orderId){
        return null;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody OrderHistoryCreateInDTO orderHistoryCreateInDTO){

        return null;
    }
}
