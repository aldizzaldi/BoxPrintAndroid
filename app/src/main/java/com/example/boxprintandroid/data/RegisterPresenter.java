package com.example.boxprintandroid.data;

import android.util.Log;

import com.example.boxprintandroid.api.ApiRetrofit;
import com.example.boxprintandroid.api.IApiEndPoint;
import com.example.boxprintandroid.model.response.RegisterResponse;
import com.example.boxprintandroid.interfaces.IRegisterView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenter {
    private IRegisterView view;
    private final IApiEndPoint apiEndPoint = ApiRetrofit.getInstance().create(IApiEndPoint.class);

    public RegisterPresenter(IRegisterView view){
        this.view = view;
    }

    public void registrationUser(String name, String email, String password, String confirmPass){
        view.showLoading();
        apiEndPoint.register(name,email,password,confirmPass).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

                if(response.isSuccessful()){
                    Log.e("berhasil", "yey berhasil register");
                    String nama = response.body().getNama();
                    view.hideLoading();
                    view.showMessage("Akun berhasil dibuat");
                    view.showLogin();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                view.showMessage(t.getMessage());
            }
        });
    }

    public void showError(){
        view.showMessage("Kosong cui fieldnya");
    }

}
