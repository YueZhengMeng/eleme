package com.shou.eleme.controller;

import com.shou.eleme.po.Business;
import com.shou.eleme.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/business")
public class BusinessController {
    @Autowired
    BusinessService businessService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Business> allBusiness() {
        return businessService.getAllBusiness();
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Business getBusinessById(@PathVariable Integer id) {
        return businessService.getBusinessById(id);
    }
}
