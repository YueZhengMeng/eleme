package com.shou.eleme.controller;

import com.shou.eleme.domain.DeliveryAddress;
import com.shou.eleme.domain.Order;
import com.shou.eleme.service.OrderService;
import com.shou.eleme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;

    @PostMapping("/pay")
    @ResponseStatus(HttpStatus.CREATED)
    Order payCart(@RequestBody DeliveryAddress deliveryAddress, @RequestParam("businessId") int businessId)
    {
        String userId=userService.getLoginUserId();
        return orderService.generateNewOrder(userId, businessId, deliveryAddress);
    }

}
