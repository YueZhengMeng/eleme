package com.shou.eleme.dto;

public class FoodMessage {
    public String foodName;
    public double foodPrice;
    public int quantity;

    public FoodMessage() {
    }

    public FoodMessage(String foodName, double foodPrice, int quantity) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.quantity = quantity;
    }

    public String getFoodName() {
        return foodName;
    }

    public FoodMessage setFoodName(String foodName) {
        this.foodName = foodName;
        return this;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public FoodMessage setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public FoodMessage setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
}
