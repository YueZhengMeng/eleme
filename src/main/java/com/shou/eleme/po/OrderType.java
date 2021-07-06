package com.shou.eleme.po;

public class OrderType {
    private int orderTypeId;
    private String orderTypename;
    private String orderTypeimg;

    public OrderType() {
    }

    public OrderType(int orderTypeId, String orderTypename, String orderTypeimg) {
        this.orderTypeId = orderTypeId;
        this.orderTypename = orderTypename;
        this.orderTypeimg = orderTypeimg;
    }

    public int getOrderTypeId() {
        return orderTypeId;
    }

    public void setOrderTypeId(int orderTypeId) {
        this.orderTypeId = orderTypeId;
    }

    public String getOrderTypename() {
        return orderTypename;
    }

    public void setOrderTypename(String orderTypename) {
        this.orderTypename = orderTypename;
    }

    public String getOrderTypeimg() {
        return orderTypeimg;
    }

    public void setOrderTypeimg(String orderTypeimg) {
        this.orderTypeimg = orderTypeimg;
    }
}
