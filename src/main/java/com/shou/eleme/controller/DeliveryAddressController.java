package com.shou.eleme.controller;

import com.shou.eleme.po.Cart;
import com.shou.eleme.po.DeliveryAddress;
import com.shou.eleme.service.DeliveryAddressService;
import com.shou.eleme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addr")
public class DeliveryAddressController {

    @Autowired
    DeliveryAddressService deliveryAddressService;

    @Autowired
    UserService userService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addDeliveryAddress(@RequestBody DeliveryAddress deliveryAddress) {
        deliveryAddress.setUserId(userService.getLoginUserId());
        deliveryAddressService.addDeliveryAddress(deliveryAddress);
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<DeliveryAddress> myDeliveryAddress() {
        return deliveryAddressService.getDeliveryAddressByUserId(userService.getLoginUserId());
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
