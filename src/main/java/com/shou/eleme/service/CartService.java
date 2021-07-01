package com.shou.eleme.service;

import com.shou.eleme.domain.Cart;
import com.shou.eleme.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartService {
    @Autowired
    CartRepository cartRepository;

    public void addCart(Cart cart)
    {
        cartRepository.insertCart(cart);
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
