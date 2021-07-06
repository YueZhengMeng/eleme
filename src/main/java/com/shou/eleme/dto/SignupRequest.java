package com.shou.eleme.dto;

import java.io.Serial;

public class SignupRequest extends JwtRequest {
    @Serial
    private static final long serialVersionUID = 5926468583005150707L;

    private int userSex;
    private String nickName;
    private String phone;

    public SignupRequest() {
    }

    public SignupRequest(String userId, String password) {
        super(userId, password);
    }

    public SignupRequest(int userSex, String nickName, String phone) {
        this.userSex = userSex;
        this.nickName = nickName;
        this.phone = phone;
    }

    public SignupRequest(String userId, String password, int userSex, String nickName, String phone) {
        super(userId, password);
        this.userSex = userSex;
        this.nickName = nickName;
        this.phone = phone;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
