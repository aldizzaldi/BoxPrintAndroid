package com.example.boxprintandroid.api;

import com.example.boxprintandroid.model.response.LoginResponse;
import com.example.boxprintandroid.model.response.RegisterResponse;
import com.example.boxprintandroid.model.response.UserResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface IApiEndPoint {

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> login(
            @Field("email") String emailUser,
            @Field("password") String passwordUser
    );

    @FormUrlEncoded
    @POST("register")
    Call<RegisterResponse> register(
            @Field("nama") String nameUser,
            @Field("email") String emailUser,
            @Field("password") String passwordSignup,
            @Field("c_password") String confirmPassword
    );

    @FormUrlEncoded
    @PUT("user")
    Call<UserResponse> editProfile(
            @Field("nama") String nameUser,
            @Field("email") String emailUser,
            @Field("no_telpon") String phoneUser
    );
}
