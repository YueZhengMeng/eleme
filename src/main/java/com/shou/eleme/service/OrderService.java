package com.shou.eleme.service;

import com.shou.eleme.dto.FoodMessage;
import com.shou.eleme.dto.OrderMessage;
import com.shou.eleme.dto.PayMessage;
import com.shou.eleme.po.*;
import com.shou.eleme.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderService {
    @Autowired
    BusinessRepository businessRepository;

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

    public Order generateNewOrder(PayMessage payMessage)
    {
        int businessId= payMessage.getBusinessId();
        String userId= payMessage.getUserId();

        double totalPrice=0.00;
        totalPrice = totalPrice + businessRepository.selectBusinessById(businessId).getDeliveryPrice();
        for (FoodMessage foodMessage : payMessage.getFoodANDQuanList()) {
            double price=foodRepository.selectFoodByNameAndBus(foodMessage.getFoodName(),businessId).getFoodPrice();
            totalPrice=totalPrice+price* foodMessage.getQuantity();
        }

        int daId=deliveryAddressRepository.selectDeliveryAddressId(payMessage.getDeliveryAddress()).getDaId();

        Order order = new Order(userId, businessId, totalPrice,daId);
        String orderDateTemp=order.getOrderDate();
        orderRepository.insertNewOrder(order);
        Order temp= orderRepository.selectMyNewOrder(userId, businessId,orderDateTemp);

        for(FoodMessage foodMessage : payMessage.getFoodANDQuanList())
        {
            int foodId=foodRepository.selectFoodByNameAndBus(foodMessage.getFoodName(),businessId).getFoodId();
            OrderDetailet orderDetailet=new OrderDetailet(temp.getOrderId(),foodId, foodMessage.getQuantity());
            orderDetailetRepository.insertOrderDetailet(orderDetailet);
        }

        return temp;
    }

    public List<OrderMessage> getMyOrder(String userId, int businessId)
    {
        List<OrderMessage> orderMessages=new ArrayList<>();
        List<Order> orders=orderRepository.selectAllMyOrder(userId,businessId);
        for (Order order : orders)
        {
            OrderMessage temp = new OrderMessage();
            temp.setOrderId(order.getOrderId());
            temp.setUserId(order.getUserId());
            temp.setOrderDate(order.getOrderDate());
            temp.setOrderTotal(order.getOrderTotal());
            temp.setOrderState(order.getOrderState());
            Business business=businessRepository.selectBusinessById(businessId);
            temp.setBusinessName(business.getBusinessName());
            temp.setDeliveryPrice(business.getDeliveryPrice());

            List<OrderDetailet> orderDetailets=orderDetailetRepository.selectOrderDetailetByOrderId(order.getOrderId());
            for (OrderDetailet orderDetailet : orderDetailets) {
                FoodMessage foodMessage =new FoodMessage();
                foodMessage.setQuantity(orderDetailet.getQuantity());
                Food food=foodRepository.selectFoodById(orderDetailet.getFoodId());
                foodMessage.setFoodName(food.getFoodName());
                foodMessage.setFoodPrice(food.getFoodPrice());
                temp.addFood(foodMessage);
            }
            orderMessages.add(temp);
        }
        return orderMessages;
    }

    /*public Order generateNewOrder(String userId, PayMessage addANDBusID)
    {
        int businessId=addANDBusID.getBusinessId();
        List<Cart> allCart=cartRepository.selectMyCart(userId, businessId);
        double totalPrice=0.00;

        for (Cart cart : allCart) {
            double price=foodRepository.selectFoodById(cart.getFoodId()).getFoodPrice();
            totalPrice=totalPrice+price*cart.getQuantity();
        }

        totalPrice = totalPrice + businessRepository.selectBusinessById(businessId).getDeliveryPrice();

        Integer daId=deliveryAddressRepository.selectDeliveryAddressId(addANDBusID.getDeliveryAddress());
        Order order = new Order(userId, businessId, totalPrice,daId);
        orderRepository.insertNewOrder(order);
        Order temp= orderRepository.selectMyNewOrder(userId, businessId);

        for(Cart cart:allCart)
        {
            OrderDetailet orderDetailet=new OrderDetailet(temp.getOrderId(),cart.getFoodId(),cart.getQuantity());
            orderDetailetRepository.insertOrderDetailet(orderDetailet);
            cartRepository.deleteCart(cart.getCartId());
        }

        return temp;
    }*/
}
