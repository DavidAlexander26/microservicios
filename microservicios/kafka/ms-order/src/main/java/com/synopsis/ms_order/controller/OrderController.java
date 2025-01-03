package com.synopsis.ms_order.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.synopsis.ms_order.bean.RequestBean;
import com.synopsis.ms_order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    IOrderService iOrderService;

    @PostMapping("/create")
    public Object updateCustomer(@RequestBody RequestBean order) throws JsonProcessingException {
        return iOrderService.createOrder(order);
    }
}
