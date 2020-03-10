package com.example.boxprintandroid.model.response;

import com.example.boxprintandroid.pojo.User;
import com.google.gson.annotations.SerializedName;

public class UserResponse {
    @SerializedName("user")
    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
