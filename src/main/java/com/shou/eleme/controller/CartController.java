package com.shou.eleme.controller;

import com.shou.eleme.po.Cart;
import com.shou.eleme.service.CartService;
import com.shou.eleme.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @GetMapping("/get/{businessId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Cart> allCart(@PathVariable Integer businessId) {
        return cartService.getMyCart(jwtUserDetailsService.getLoginUserId(), businessId);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCart(@RequestBody List<Cart> cart) {
        cartService.addCart(cart);
    }
}
