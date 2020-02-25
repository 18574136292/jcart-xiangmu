package io.itcast.cfc.controller;

import io.itcast.cfc.model.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/list")
    public String getList(){
        return null;
    }
    @GetMapping("/getOneOrder")
    public Order getOneOrder(Integer orderId){
        return null;
    }
    @PostMapping("/updateOrder")
    public void updateOrder(Order order){

    }
    @PostMapping("/deleteOrder")
    public void deleteOrder(Integer orderId){

    }
}
