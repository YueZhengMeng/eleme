package com.shou.eleme.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderResponse {
    private int orderId;
    private String userId;
    private String businessName;
    private double deliveryPrice;
    private String orderDate;
    private double orderTotal;
    private int orderState;
    private List<FoodMessage> foods = new ArrayList<>();

    public OrderResponse() {
    }

    public OrderResponse(int orderId, String userId, String businessName, double deliveryPrice, String orderDate, double orderTotal, int orderState, List<FoodMessage> foods) {
        this.orderId = orderId;
        this.userId = userId;
        this.businessName = businessName;
        this.deliveryPrice = deliveryPrice;
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
        this.orderState = orderState;
        this.foods = foods;
    }

    public void addFood(FoodMessage food) {
        this.foods.add(food);
    }

    public int getOrderId() {
        return orderId;
    }

    public OrderResponse setOrderId(int orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public OrderResponse setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getBusinessName() {
        return businessName;
    }

    public OrderResponse setBusinessName(String businessName) {
        this.businessName = businessName;
        return this;
    }

    public double getDeliveryPrice() {
        return deliveryPrice;
    }

    public OrderResponse setDeliveryPrice(double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
        return this;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public OrderResponse setOrderDate(String orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public OrderResponse setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
        return this;
    }

    public int getOrderState() {
        return orderState;
    }

    public OrderResponse setOrderState(int orderState) {
        this.orderState = orderState;
        return this;
    }

    public List<FoodMessage> getFoods() {
        return foods;
    }

    public OrderResponse setFoods(List<FoodMessage> foods) {
        this.foods = foods;
        return this;
    }
}
