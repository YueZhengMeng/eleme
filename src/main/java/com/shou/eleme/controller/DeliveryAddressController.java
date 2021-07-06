package com.shou.eleme.controller;

import com.shou.eleme.po.DeliveryAddress;
import com.shou.eleme.service.DeliveryAddressService;
import com.shou.eleme.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/addr")
public class DeliveryAddressController {

    @Autowired
    private DeliveryAddressService deliveryAddressService;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addDeliveryAddress(@RequestBody DeliveryAddress deliveryAddress) {
        deliveryAddress.setUserId(jwtUserDetailsService.getLoginUserId());
        deliveryAddressService.addDeliveryAddress(deliveryAddress);
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<DeliveryAddress> myDeliveryAddress() {
        return deliveryAddressService.getDeliveryAddressByUserId(jwtUserDetailsService.getLoginUserId());
    }

    @PutMapping("/change")
    @ResponseStatus(HttpStatus.OK)
    public void changeDeliveryAddress(@RequestBody DeliveryAddress deliveryAddress) {
        deliveryAddressService.changeDeliveryAddress(deliveryAddress);
    }

    @DeleteMapping("/delete/{daId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDeliveryAddress(@PathVariable int daId) {
        deliveryAddressService.deleteDeliveryAddress(daId);
    }

}
