package com.example.boxprintandroid.model.response;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("id_user")
    int userId;

    @SerializedName("token")
    String token;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}