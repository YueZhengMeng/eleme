package com.shou.eleme.controller;


import com.shou.eleme.dto.OrderResponse;
import com.shou.eleme.dto.PayRequest;
import com.shou.eleme.po.Order;
import com.shou.eleme.service.JwtUserDetailsService;
import com.shou.eleme.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @PostMapping("/pay")
    @ResponseStatus(HttpStatus.CREATED)
    Order pay(@RequestBody PayRequest payRequest) {
        String userId = jwtUserDetailsService.getLoginUserId();
        payRequest.setUserId(userId);
        return orderService.generateNewOrder(payRequest);
    }

    @GetMapping("/get/{businessId}")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponse> myOrderMessage(@PathVariable Integer businessId) {
        return orderService.getMyOrder(jwtUserDetailsService.getLoginUserId(), businessId);
    }

}
