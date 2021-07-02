package com.shou.eleme.controller;


import com.shou.eleme.dto.AddANDBusID;
import com.shou.eleme.po.Order;
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
    Order payCart(@RequestBody AddANDBusID addANDBusID)
    {
        String userId=userService.getLoginUserId();
        return orderService.generateNewOrder(userId, addANDBusID);
    }

}
