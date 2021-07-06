package com.shou.eleme.po;

public class User {
    private String userId;
    private String password;
    private String userName;
    private String phone;
    private int userSex;
    private String userImg;
    private int delTag;

    public User() {
    }

    public User(String userId, String password,String phone,int userSex,String userName) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.phone = phone;
        this.userSex = userSex;
        this.userImg = "/tx/tx00.jpg";
        this.delTag = 1;
    }

    public User(String userId, String password, String userName, String phone, int userSex, String userImg, int delTag) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.phone = phone;
        this.userSex = userSex;
        this.userImg = userImg;
        this.delTag = delTag;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public int getDelTag() {
        return delTag;
    }

    public void setDelTag(int delTag) {
        this.delTag = delTag;
    }
}
