package com.example.boxprintandroid.model.response;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse {
    @SerializedName("token")
    String token;

    @SerializedName("nama")
    String nama;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
