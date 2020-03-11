package com.example.boxprintandroid.activity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.boxprintandroid.R;
import com.example.boxprintandroid.interfaces.IProfileView;
import com.example.boxprintandroid.pojo.User;

public class EditProfileActivity extends AppCompatActivity implements IProfileView {
    @Override

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
    }

    @Override
    public void showProfile(User user) {

    }

    @Override
    public void moveToSplashscreen() {

    }

    @Override
    public void moveToEditProfile() {

    }

    @Override
    public void showMessage(String message) {

    }
}
