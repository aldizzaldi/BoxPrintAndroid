package com.example.boxprintandroid.api;

import com.example.boxprintandroid.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IApiEndPoint {

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> login(
            @Field("email") String emailUser,
            @Field("password") String passwordUser
    );
}
