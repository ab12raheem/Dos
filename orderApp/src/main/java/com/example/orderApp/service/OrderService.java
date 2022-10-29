package com.example.orderApp.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class OrderService  {
    @Autowired
    private RestTemplate restTemplate;
    public HashMap<String,String> purchaseBook(Integer bookId) {
        // check if the book is exist and have quantity
        HashMap<String,String> response = restTemplate.getForObject("http://localhost:8090/api/v1/catalog/buyBookById/" + bookId, HashMap.class);
        return response;
    }
}

