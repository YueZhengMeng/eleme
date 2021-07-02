package com.shou.eleme.controller;


import com.shou.eleme.dto.PayMessage;
import com.shou.eleme.dto.OrderMessage;
import com.shou.eleme.po.Order;
import com.shou.eleme.service.OrderService;
import com.shou.eleme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;

    @PostMapping("/pay")
    @ResponseStatus(HttpStatus.CREATED)
    Order payCart(@RequestBody PayMessage payMessage)
    {
        String userId=userService.getLoginUserId();
        payMessage.setUserId(userId);
        return orderService.generateNewOrder(payMessage);
    }

    @GetMapping("/get/{businessId}")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderMessage> myOrderMessage(@PathVariable Integer businessId) {
        return orderService.getMyOrder(userService.getLoginUserId(),businessId);
    }

}
