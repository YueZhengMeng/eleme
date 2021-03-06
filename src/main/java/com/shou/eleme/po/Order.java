package com.shou.eleme.po;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
    private int orderId;
    private String userId;
    private int businessId;
    private String orderDate;
    private double orderTotal;
    private int daId;
    private int orderState;

    public Order() {
    }

    public Order(String userId, int businessId, double orderTotal, int daId) {
        this.userId = userId;
        this.businessId = businessId;
        this.orderTotal = orderTotal;
        this.daId = daId;
        this.orderDate=getSystemTime();
        this.orderState = 0;
    }

    public Order(int orderId, String userId, int businessId, String orderDate, double orderTotal, int daId, int orderState) {
        this.orderId = orderId;
        this.userId = userId;
        this.businessId = businessId;
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
        this.daId = daId;
        this.orderState = orderState;
    }

    public static String transTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    public static String getSystemTime() {
        Date date = new Date();
        return transTime(date);
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = transTime(orderDate);
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public int getDaId() {
        return daId;
    }

    public void setDaId(int daId) {
        this.daId = daId;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }
}
