package com.shou.eleme.dto;

import java.io.Serial;
import java.io.Serializable;

public class JwtRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 5926468583005150707L;

    protected String userId;
    protected String password;

    public JwtRequest() {
    }

    public JwtRequest(String userId, String password) {
        this.setUserId(userId);
        this.setPassword(password);
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}