package com.shou.eleme.dto;

import com.shou.eleme.po.DeliveryAddress;

public class AddANDBusID {
    public int daId;
    public String contactName;
    public int contactSex;
    public String contactTel;
    public String address;
    public String userId;
    public int businessId;

    public AddANDBusID() {
    }

    public AddANDBusID(int daId, String contactName, int contactSex, String contactTel, String address, String userId, int businessId) {
        this.daId = daId;
        this.contactName = contactName;
        this.contactSex = contactSex;
        this.contactTel = contactTel;
        this.address = address;
        this.userId = userId;
        this.businessId = businessId;
    }

    public DeliveryAddress getDeliveryAddress()
    {
        return new DeliveryAddress(this.daId, this.contactName, this.contactSex, this.contactTel, this.address, this.userId);
    }

    public int getDaId() {
        return daId;
    }

    public AddANDBusID setDaId(int daId) {
        this.daId = daId;
        return this;
    }

    public String getContactName() {
        return contactName;
    }

    public AddANDBusID setContactName(String contactName) {
        this.contactName = contactName;
        return this;
    }

    public int getContactSex() {
        return contactSex;
    }

    public AddANDBusID setContactSex(int contactSex) {
        this.contactSex = contactSex;
        return this;
    }

    public String getContactTel() {
        return contactTel;
    }

    public AddANDBusID setContactTel(String contactTel) {
        this.contactTel = contactTel;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public AddANDBusID setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public AddANDBusID setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public int getBusinessId() {
        return businessId;
    }

    public AddANDBusID setBusinessId(int businessId) {
        this.businessId = businessId;
        return this;
    }
}
