package com.shou.eleme.controller;

import com.shou.eleme.dao.BusinessRepository;
import com.shou.eleme.dao.OrderTypeRepository;
import com.shou.eleme.po.Business;
import com.shou.eleme.po.OrderType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/index")
public class IndexController {

    @Autowired
    OrderTypeRepository orderTypeRepository;

    @Autowired
    BusinessRepository businessRepository;

    @GetMapping("/ordertype")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderType> allOrderTypes() {
        return orderTypeRepository.selectAllOrderTypes();
    }

    @GetMapping("/business")
    @ResponseStatus(HttpStatus.OK)
    public List<Business> allBusiness() {
        return businessRepository.selectAllBusiness();
    }

}
