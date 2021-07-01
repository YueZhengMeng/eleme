package com.shou.eleme.domain;

public class User {
    public String userId;
    public String password;
    public String userName;
    public int userSex;
    public String userImg;
    public int delTag;

    public User(String userId, String password, String userName, int userSex, String userImg, int delTag) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
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
