package com.shou.eleme.domain;

public class DeliveryAddress {
    public int daId;
    public String contactName;
    public int contactSex;
    public String contactTel;
    public String address;
    public String userId;

    public int getDaId() {
        return daId;
    }

    public void setDaId(int daId) {
        this.daId = daId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public int getContactSex() {
        return contactSex;
    }

    public void setContactSex(int contactSex) {
        this.contactSex = contactSex;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
