package com.shou.eleme.dto;

import com.shou.eleme.po.DeliveryAddress;

import java.util.List;

public class PayRequest {
    private int daId;
    private String userId;
    private int businessId;
    private List<FoodMessage> foodMessageList;

    public PayRequest() {
    }

    public PayRequest(int daId, String userId, int businessId, List<FoodMessage> foodMessageList) {
        this.daId = daId;
        this.userId = userId;
        this.businessId = businessId;
        this.foodMessageList = foodMessageList;
    }

    public int getDaId() {
        return daId;
    }

    public void setDaId(int daId) {
        this.daId = daId;
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

    public List<FoodMessage> getFoodMessageList() {
        return foodMessageList;
    }

    public void setFoodMessageList(List<FoodMessage> foodMessageList) {
        this.foodMessageList = foodMessageList;
    }
}
