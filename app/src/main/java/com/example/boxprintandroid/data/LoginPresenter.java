package com.example.boxprintandroid.data;

import android.util.Log;
import android.widget.Toast;

import com.example.boxprintandroid.SharedPrefUtils;
import com.example.boxprintandroid.api.ApiRetrofit;
import com.example.boxprintandroid.api.IApiEndPoint;
import com.example.boxprintandroid.model.response.LoginResponse;
import com.example.boxprintandroid.ui.ILoginView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {
    private ILoginView view;
    private final IApiEndPoint apiEndPoint = ApiRetrofit.getInstance().create(IApiEndPoint.class);

    public LoginPresenter(ILoginView view){
        this.view = view;
    }

    public void doLogin(final String txtEmail, final String txtPassword){
        view.showLoading();
        apiEndPoint.login(txtEmail, txtPassword).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                String token;

                if(response.isSuccessful()){
                    token = "Bearer" + response.body().getToken();
                    SharedPrefUtils.setStringSharedPref("token", token);
                    SharedPrefUtils.setStringSharedPref("email", txtEmail);
                    Log.e("Good", "Successed for login");
                    view.hideLoading();
                    view.moveToHomepage();
                    Log.e("Good", "mamamia");
                }
                else{
                    view.hideLoading();
                    view.showMessage("Username or password don't match");
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                view.showMessage(t.getMessage());
                view.hideLoading();
                Log.e("error", txtEmail + "_" + txtPassword);
            }
        });
    }

    public void showError(){
        view.showMessage("Blanks");
    }

}
