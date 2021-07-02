package com.shou.eleme.po;

public class Food {
    public int foodId;
    public String foodName;
    public String foodExplain;
    public String foodImg;
    public double foodPrice;
    public int businessId;
    public String remarks;

    public Food() {
    }

    public Food(int foodId, String foodName, String foodExplain, String foodImg, double foodPrice, int businessId, String remarks) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodExplain = foodExplain;
        this.foodImg = foodImg;
        this.foodPrice = foodPrice;
        this.businessId = businessId;
        this.remarks = remarks;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodExplain() {
        return foodExplain;
    }

    public void setFoodExplain(String foodExplain) {
        this.foodExplain = foodExplain;
    }

    public String getFoodImg() {
        return foodImg;
    }

    public void setFoodImg(String foodImg) {
        this.foodImg = foodImg;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
