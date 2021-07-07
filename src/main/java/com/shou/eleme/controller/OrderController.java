package com.shou.eleme.controller;


import com.shou.eleme.dto.OrderResponse;
import com.shou.eleme.dto.PayRequest;
import com.shou.eleme.po.Order;
import com.shou.eleme.service.FoodService;
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

    @Autowired
    private FoodService foodService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    Order newOrder(@RequestBody PayRequest payRequest) {
        String userId = jwtUserDetailsService.getLoginUserId();
        payRequest.setUserId(userId);
        int foodId0=(payRequest.getFoodMessageList()).get(0).getFoodId();
        int businessId=foodService.getFoodById(foodId0).getBusinessId();
        payRequest.setBusinessId(businessId);
        return orderService.generateNewOrder(payRequest);
    }

    @PutMapping("/pay/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public void payOrder(@PathVariable Integer orderId)
    {
        orderService.payOrder(orderId);
    }


    @GetMapping("/mybus/{businessId}")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponse> myBusOrderMessage(@PathVariable Integer businessId) {
        return orderService.getOrderByUserIdAndBus(jwtUserDetailsService.getLoginUserId(), businessId);
    }

    @GetMapping("/my")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponse> myOrderMessage() {
        return orderService.getOrderByUserId(jwtUserDetailsService.getLoginUserId());
    }

    @GetMapping("/get/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public OrderResponse getOrderMessage(@PathVariable Integer orderId) {
        return orderService.getOrderMessage(orderId);
    }

}
