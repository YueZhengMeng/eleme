package com.shou.eleme.service;

import com.shou.eleme.domain.Cart;
import com.shou.eleme.domain.DeliveryAddress;
import com.shou.eleme.domain.Order;
import com.shou.eleme.domain.OrderDetailet;
import com.shou.eleme.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderService {
    @Autowired
    FoodRepository foodRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderDetailetRepository orderDetailetRepository;

    @Autowired
    DeliveryAddressRepository deliveryAddressRepository;

    public Order generateNewOrder(String userId, Integer businessId, DeliveryAddress deliveryAddress){
        List<Cart> allCart=cartRepository.selectMyCart(userId, businessId);
        double totalPrice=0.00;

        for (Cart cart : allCart) {
            double price=foodRepository.selectFoodById(cart.getFoodId()).getFoodPrice();
            totalPrice=totalPrice+price*cart.getQuantity();
        }

        Integer daId=deliveryAddressRepository.selectDeliveryAddressId(deliveryAddress);
        Order order = new Order(userId, businessId, totalPrice,daId);
        orderRepository.insertNewOrder(order);
        Order temp= orderRepository.selectMyOrder(userId, businessId);

        for(Cart cart:allCart)
        {
            OrderDetailet orderDetailet=new OrderDetailet(temp.getOrderId(),cart.getFoodId(),cart.getQuantity());
            cartRepository.deleteCart(cart.getCartId());
        }

        return temp;
    }
}
