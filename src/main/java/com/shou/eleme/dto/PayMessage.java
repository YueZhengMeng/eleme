package com.shou.eleme.dto;

import com.shou.eleme.po.DeliveryAddress;

import java.util.List;

public class PayMessage {
    public String contactName;
    public int contactSex;
    public String contactTel;
    public String address;
    public String userId;
    public int businessId;
    List<FoodMessage> foodMessageList;

    public PayMessage() {
    }

    public PayMessage(String contactName, int contactSex, String contactTel, String address, String userId, int businessId, List<FoodMessage> foodMessageList) {
        this.contactName = contactName;
        this.contactSex = contactSex;
        this.contactTel = contactTel;
        this.address = address;
        this.userId = userId;
        this.businessId = businessId;
        this.foodMessageList = foodMessageList;
    }

    public DeliveryAddress getDeliveryAddress()
    {
        return new DeliveryAddress(this.contactName, this.contactSex, this.contactTel,this.address,this.userId);
    }


    public String getContactName() {
        return contactName;
    }

    public PayMessage setContactName(String contactName) {
        this.contactName = contactName;
        return this;
    }

    public int getContactSex() {
        return contactSex;
    }

    public PayMessage setContactSex(int contactSex) {
        this.contactSex = contactSex;
        return this;
    }

    public String getContactTel() {
        return contactTel;
    }

    public PayMessage setContactTel(String contactTel) {
        this.contactTel = contactTel;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public PayMessage setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public PayMessage setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public int getBusinessId() {
        return businessId;
    }

    public PayMessage setBusinessId(int businessId) {
        this.businessId = businessId;
        return this;
    }

    public List<FoodMessage> getFoodANDQuanList() {
        return foodMessageList;
    }

    public PayMessage setFoodANDQuanList(List<FoodMessage> foodMessageList) {
        this.foodMessageList = foodMessageList;
        return this;
    }
}
