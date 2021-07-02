package com.shou.eleme.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderMessage {
    public int orderId;
    public String userId;
    public String businessName;
    public double deliveryPrice;
    public String orderDate;
    public double orderTotal;
    public int orderState;
    public List<FoodMessage> foods;

    public OrderMessage() {
        this.foods=new ArrayList<>();
    }

    public OrderMessage(int orderId, String userId, String businessName, double deliveryPrice, String orderDate, double orderTotal, int orderState, List<FoodMessage> foods) {
        this.orderId = orderId;
        this.userId = userId;
        this.businessName = businessName;
        this.deliveryPrice = deliveryPrice;
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
        this.orderState = orderState;
        this.foods = foods;
    }

    public void addFood(FoodMessage food)
    {
        this.foods.add(food);
    }

    public int getOrderId() {
        return orderId;
    }

    public OrderMessage setOrderId(int orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public OrderMessage setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getBusinessName() {
        return businessName;
    }

    public OrderMessage setBusinessName(String businessName) {
        this.businessName = businessName;
        return this;
    }

    public double getDeliveryPrice() {
        return deliveryPrice;
    }

    public OrderMessage setDeliveryPrice(double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
        return this;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public OrderMessage setOrderDate(String orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public OrderMessage setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
        return this;
    }

    public int getOrderState() {
        return orderState;
    }

    public OrderMessage setOrderState(int orderState) {
        this.orderState = orderState;
        return this;
    }

    public List<FoodMessage> getFoods() {
        return foods;
    }

    public OrderMessage setFoods(List<FoodMessage> foods) {
        this.foods = foods;
        return this;
    }
}
