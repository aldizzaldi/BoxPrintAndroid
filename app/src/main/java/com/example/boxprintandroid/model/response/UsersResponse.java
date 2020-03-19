package com.example.boxprintandroid.model.response;

import com.example.boxprintandroid.pojo.User;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class UsersResponse {

    @SerializedName("user")
    ArrayList<User> users;

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
