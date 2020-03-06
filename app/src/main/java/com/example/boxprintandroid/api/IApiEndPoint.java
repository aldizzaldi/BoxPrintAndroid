package com.example.boxprintandroid.api;

import com.example.boxprintandroid.model.response.LoginResponse;
import com.example.boxprintandroid.model.response.RegisterResponse;
import com.example.boxprintandroid.model.response.UserResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

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
            @Header("Authorization") String header,
            @Field("nama") String nameUser,
            @Field("email") String emailUser,
            @Field("no_telpon") String phoneUser
    );

    @GET("user/{id}")
    Call<UserResponse> showProfile(
            @Header("Authorization") String header,
            @Path("id") int id
    );


}
