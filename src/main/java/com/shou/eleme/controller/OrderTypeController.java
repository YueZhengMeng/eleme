package com.shou.eleme.controller;

import com.shou.eleme.po.OrderType;
import com.shou.eleme.service.OrderTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/ordertype")
public class OrderTypeController {

    @Autowired
    private OrderTypeService orderService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderType> allOrderTypes() {
        return orderService.getAllOrderTypes();
    }
}
