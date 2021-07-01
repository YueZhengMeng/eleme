package com.shou.eleme.domain;

public class OrderDetailet {
    public int odId;
    public int orderId;
    public int foodId;
    public int quantity;

    public OrderDetailet() {
    }

    public OrderDetailet(int odId, int orderId, int foodId, int quantity) {
        this.odId = odId;
        this.orderId = orderId;
        this.foodId = foodId;
        this.quantity = quantity;
    }

    public OrderDetailet(int orderId, int foodId, int quantity) {
        this.orderId = orderId;
        this.foodId = foodId;
        this.quantity = quantity;
    }

    public int getOdId() {
        return odId;
    }

    public void setOdId(int odId) {
        this.odId = odId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
