package com.shou.eleme.domain;

public class Cart {
    public int cartId;
    public int foodId;
    public int businessId;
    public String userId;
    public int quantity;

    public Cart(int foodId, int businessId, String userId, int quantity) {
        this.foodId = foodId;
        this.businessId = businessId;
        this.userId = userId;
        this.quantity = quantity;
    }

    public Cart(int cartId, int foodId, int businessId, String userId, int quantity) {
        this.cartId = cartId;
        this.foodId = foodId;
        this.businessId = businessId;
        this.userId = userId;
        this.quantity = quantity;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
