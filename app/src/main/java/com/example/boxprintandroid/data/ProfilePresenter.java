package com.example.boxprintandroid.data;

import android.util.Log;

import com.example.boxprintandroid.api.ApiRetrofit;
import com.example.boxprintandroid.api.IApiEndPoint;
import com.example.boxprintandroid.interfaces.IProfileView;
import com.example.boxprintandroid.model.response.UserResponse;
import com.example.boxprintandroid.pojo.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilePresenter {
    private IProfileView view;
    private final IApiEndPoint apiEndPoint = ApiRetrofit.getInstance().create(IApiEndPoint.class);
    String token = "Bearer " + "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiMDdmMjc5ZDFjZTNjNmY4OTkwMTYwZTgwY2QwNzI1ODlhODNhY2Q4ODQ3N2Q4OGU2MGM1YjUxMTBhMzdiMjZjMTg0Y2FlNTBkMTJhYjVkYmIiLCJpYXQiOjE1ODMyMDg4NTcsIm5iZiI6MTU4MzIwODg1NywiZXhwIjoxNjE0NzQ0ODU3LCJzdWIiOiIxIiwic2NvcGVzIjpbXX0.X54bLcORnJ8kyCFsXewnWeabbiBCR3o4ExeRhFZ5k3mRneZYh8v6vmXXiDz5k8jaSQaoQ6nc_el0FTRMxbxnhvamhpJAY_htMQtCUm-164L-i5_U5kGe4xblDClbM0oqLYv7a2orEc0C5QPbz17kXfJp5Q8jJgW3xXg0QXQjgc7wExG2msap8JuGmlbZXBX-WU02IvMELDMwIAuqwtnzxu_zB5yB2PL5KKb6BRKd0OZeAd7c25cQiQk1CIDhMyCO_IS3mqkPoYUBCOUrZ0F16717rdJUqXz4cNlIqrkNr6Wu8rMecA2SH7Eqg6kKvc0PCeb9QhU5KEEJS9m6xcIxnG2h-SuZC66NUlPvAQ6WP23YmFHnao36fscaE4DngLHwnJbAe8F3GoeDmDZTd_1CLGxjdEB7zNWLh718dUeWZnhhnfftUS4kMML6kOzYHjMHaDYyclRQ5Tx5P1ngU3K4fRMxzJbQN086pxLfS2NRuvTWnM0WrZDvXQKn1WYcRXODsXhQ8AKYXJgaIUrJKEpSFUQhCoNtx9SXc8fF7NSD51uU4gKDcHNhTGUttF1s0LDnMIAUWmCBhLGiskAE4xNoC_xGUsQlVNMdRY0D8-dUNQ_TQP9tXAg5aIhuxjHPdTtpKui4Pg6hyGaH43WALGAwNNncOEQsHszs4n5arY16l1U";
    public ProfilePresenter(IProfileView view){
        this.view = view;
    }

    public void showProfile(){
        apiEndPoint.showProfile(token, 1).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()){
                    view.showProfile(response.body().getUser());
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                view.showMessage(t.getMessage());
            }
        });
    }

    public void editProfile(User user){
        String nama = user.getNama();
        String email = user.getEmail();
        String noTelpon = user.getNoTelpon();

        apiEndPoint.editProfile(token, nama, email, noTelpon).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()){
                    view.showMessage("Profil berhasil di update");
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                view.showMessage(t.getMessage());
            }
        });
    }
}
