package com.shou.eleme.domain;

public class DeliveryAddress {
    public int daId;
    public String contactName;
    public int contactSex;
    public String contactTel;
    public String address;
    public String userId;

    public DeliveryAddress(int daId, String contactName, int contactSex, String contactTel, String address, String userId) {
        this.daId = daId;
        this.contactName = contactName;
        this.contactSex = contactSex;
        this.contactTel = contactTel;
        this.address = address;
        this.userId = userId;
    }

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
