package com.example.orderApp.controller;


import com.example.orderApp.service.OrderService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(path = "api/v1/order")
public class OrderController {
    private final OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PutMapping("purchaseByBookId/{bookId}")
    public HashMap<String,String> purchaseBook(@PathVariable Integer bookId) {
        return orderService.purchaseBook(bookId);
    }
}

