package com.shou.eleme.service;

import com.shou.eleme.po.Cart;
import com.shou.eleme.dao.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public void addCart(List<Cart> cart)
    {
        for (Cart c: cart) {
            cartRepository.insertCart(c);
        }
    }

    public void deleteCart(Integer cartId)
    {
        cartRepository.deleteCart(cartId);
    }

    public List<Cart> getMyCart(String userId,Integer businessId)
    {
        return cartRepository.selectMyCart(userId, businessId);
    }
}
