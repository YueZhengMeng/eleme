package com.shou.eleme.service;

import com.shou.eleme.dto.FoodMessage;
import com.shou.eleme.dto.OrderResponse;
import com.shou.eleme.dto.PayRequest;
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
    private BusinessRepository businessRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailetRepository orderDetailetRepository;

    public Order generateNewOrder(PayRequest payRequest) {
        int businessId = payRequest.getBusinessId();
        String userId = payRequest.getUserId();

        double totalPrice = 0.00;
        totalPrice = totalPrice + businessRepository.selectBusinessById(businessId).getDeliveryPrice();
        for (FoodMessage foodMessage : payRequest.getFoodMessageList()) {
            double price = foodRepository.selectFoodById(foodMessage.getFoodId()).getFoodPrice();
            totalPrice = totalPrice + price * foodMessage.getQuantity();
        }

        int daId = payRequest.getDaId();
        Order order = new Order(userId, businessId, totalPrice, daId);
        String orderDateTemp = order.getOrderDate();
        orderRepository.insertNewOrder(order);
        Order temp = orderRepository.selectMyNewOrder(userId, businessId, orderDateTemp);

        for (FoodMessage foodMessage : payRequest.getFoodMessageList()) {
            int foodId = foodMessage.getFoodId();
            OrderDetailet orderDetailet = new OrderDetailet(temp.getOrderId(), foodId, foodMessage.getQuantity());
            orderDetailetRepository.insertOrderDetailet(orderDetailet);
        }

        return temp;
    }

    public List<OrderResponse> getOrderByUserIdAndBus(String userId, int businessId) {
        List<OrderResponse> orderResponses = new ArrayList<>();
        List<Order> orders = orderRepository.selectAllMyOrder(userId, businessId);
        for (Order order : orders) {
            OrderResponse temp = generateOrderResponse(order);
            orderResponses.add(temp);
        }
        return orderResponses;
    }

    public OrderResponse getOrderMessage(int orderId) {
        Order order = orderRepository.selectOrderById(orderId);
        return generateOrderResponse(order);
    }

    public List<OrderResponse> getOrderByUserId(String userId) {
        List<OrderResponse> orderResponses = new ArrayList<>();
        List<Order> orders = orderRepository.selectOrderByUserId(userId);
        for (Order order : orders) {
            OrderResponse temp = generateOrderResponse(order);
            orderResponses.add(temp);
        }
        return orderResponses;
    }

    public void payOrder(Integer orderId) {
        orderRepository.updateOrderPay(orderId);
    }

    private OrderResponse generateOrderResponse(Order order)
    {
        OrderResponse temp = new OrderResponse();
        temp.setOrderId(order.getOrderId());
        temp.setUserId(order.getUserId());
        temp.setOrderDate(order.getOrderDate());
        temp.setOrderTotal(order.getOrderTotal());
        temp.setOrderState(order.getOrderState());
        Business business = businessRepository.selectBusinessById(order.getBusinessId());
        temp.setBusinessName(business.getBusinessName());
        temp.setDeliveryPrice(business.getDeliveryPrice());

        List<OrderDetailet> orderDetailets = orderDetailetRepository.selectOrderDetailetByOrderId(order.getOrderId());
        for (OrderDetailet orderDetailet : orderDetailets) {
            FoodMessage foodMessage = new FoodMessage();
            foodMessage.setQuantity(orderDetailet.getQuantity());
            Food food = foodRepository.selectFoodById(orderDetailet.getFoodId());
            foodMessage.setFoodId(food.getFoodId());
            foodMessage.setFoodName(food.getFoodName());
            foodMessage.setFoodPrice(food.getFoodPrice());
            temp.addFood(foodMessage);
        }
        return temp;
    }

    /*public Order generateNewOrder(String userId, PayRequest addANDBusID)
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
