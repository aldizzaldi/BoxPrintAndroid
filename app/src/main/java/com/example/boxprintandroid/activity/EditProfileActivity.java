package com.example.boxprintandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.boxprintandroid.R;
import com.example.boxprintandroid.interfaces.IProfileView;
import com.example.boxprintandroid.pojo.User;

public class EditProfileActivity extends AppCompatActivity implements IProfileView {
    EditText editNama;
    EditText editEmail;
    EditText editPhone;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        editNama = (EditText) findViewById(R.id.editName);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editPhone = (EditText) findViewById(R.id.editPhoneNumber);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        User user = (User) bundle.getSerializable("user");
//        editNama.setText(user.getNama());
//        editEmail.setText(user.getEmail());
//        editPhone.setText(user.getNoTelpon());
        Log.e("nama user", user.getNama());
        Log.e("nama user", user.getEmail());
        Log.e("nama user", user.getNoTelpon());
    }

    @Override
    public void showProfile(User user) {

    }

    @Override
    public void moveToSplashscreen() {

    }

    @Override
    public void moveToEditProfile(User user) {

    }

    @Override
    public void showMessage(String message) {

    }
}
