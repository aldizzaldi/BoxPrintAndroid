package com.example.boxprintandroid.data;

import android.util.Log;

import com.example.boxprintandroid.api.ApiRetrofit;
import com.example.boxprintandroid.api.IApiEndPoint;
import com.example.boxprintandroid.interfaces.IHomeView;
import com.example.boxprintandroid.model.response.ItemResponse;
import com.example.boxprintandroid.model.response.ItemsResponse;
import com.example.boxprintandroid.model.response.UsersResponse;
import com.example.boxprintandroid.pojo.Item;
import com.example.boxprintandroid.pojo.User;
import com.example.boxprintandroid.utils.SharedPrefUtils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter {
    private IHomeView view;
    private final IApiEndPoint apiEndPoint = ApiRetrofit.getInstance().create(IApiEndPoint.class);
    ArrayList<Item> items = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();
    String token = SharedPrefUtils.getStringSharedPref("token", "null");;

    public HomePresenter(IHomeView view) {
        this.view = view;
    }

    public void getAllItemsInHome(){
        apiEndPoint.getAllItem(token).enqueue(new Callback<ItemsResponse>() {
            @Override
            public void onResponse(Call<ItemsResponse> call, Response<ItemsResponse> response) {
                if (response.isSuccessful()){
                    int size = 0;
                    size = response.body().getItmes().size();

                    for (int i = 0; i < size; i++){
                        items.add(response.body().getItmes().get(i));
                        Log.e("item", items.get(i).getNamaItem());
                    }
                    view.getAllItems(items);
                }

            }

            @Override
            public void onFailure(Call<ItemsResponse> call, Throwable t) {


            }
        });
    }

    public void getAllUserInHome(){
        apiEndPoint.getAllUser(token).enqueue(new Callback<UsersResponse>() {
            @Override
            public void onResponse(Call<UsersResponse> call, Response<UsersResponse> response) {
                if (response.isSuccessful()){
                    int size = response.body().getUsers().size();
                    for (int i = 0; i < size; i++){
                        users.add(response.body().getUsers().get(i));
                        Log.e("user", users.get(i).getNama());
                    }
                    view.getAllUsers(users);
                }
            }

            @Override
            public void onFailure(Call<UsersResponse> call, Throwable t) {

            }
        });
    }
}
