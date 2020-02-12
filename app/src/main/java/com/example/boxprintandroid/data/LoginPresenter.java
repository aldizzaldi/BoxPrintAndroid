package com.example.boxprintandroid.data;

import android.util.Log;

import com.example.boxprintandroid.SharedPrefUtils;
import com.example.boxprintandroid.api.ApiRetrofit;
import com.example.boxprintandroid.api.IApiEndPoint;
import com.example.boxprintandroid.model.LoginResponse;
import com.example.boxprintandroid.model.LoginResponse;
import com.example.boxprintandroid.ui.login.ILoginView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {
    private ILoginView view;
    private final IApiEndPoint apiEndPoint = ApiRetrofit.getInstance().create(IApiEndPoint.class);

    public LoginPresenter(ILoginView view){
        this.view = view;
    }

    public void doLogin(final String txtEmail, String txtPassword){
        view.showLoading();
        apiEndPoint.login(txtEmail, txtPassword).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                String token;

                if(response.isSuccessful()){
                    token = "Bearer" + response.body().getToken();
                    SharedPrefUtils.setStringSharedPref("token", token);
                    SharedPrefUtils.setStringSharedPref("email", txtEmail);
                    Log.e("Good", "Sukses login");
                    view.hideLoading();
                    view.moveToHomepage();
                }
                else{
                    view.hideLoading();
                    view.showMessage("Username dan password tidak cocok");
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                view.showMessage(t.getMessage());

            }
        });
    }

    public void showError(){
        view.showMessage("Username dan password tidak boleh kosong");
        view.showError();
    }
}
