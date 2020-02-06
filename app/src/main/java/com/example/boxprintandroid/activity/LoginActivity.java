package com.example.boxprintandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.boxprintandroid.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    CardView loginContainer, signupContainer;
    TextView buttonSignup, buttonLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin =  findViewById(R.id.buttonLogin);
        loginContainer = findViewById(R.id.signupActivity);
        signupContainer = findViewById(R.id.loginActivity);
        buttonSignup = findViewById(R.id.button_to_signup);
        buttonLogin = findViewById(R.id.button_to_login);
        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginContainer.setVisibility(View.GONE);
                signupContainer.setVisibility(View.VISIBLE);
            }
        });
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginContainer.setVisibility(View.VISIBLE);
                signupContainer.setVisibility(View.GONE);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

}