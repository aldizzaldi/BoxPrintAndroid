package com.example.boxprintandroid.ui.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.boxprintandroid.R;
import com.example.boxprintandroid.SharedPrefUtils;
import com.example.boxprintandroid.ui.home.HomeFragment;

public class SplashScreen extends AppCompatActivity implements ISplashScreenView {

    private final int DELAY = 4000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        SharedPrefUtils.initSharedPreference("BOXPRINT", this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String token = SharedPrefUtils.getStringSharedPref("token", "null");

                if(token.equalsIgnoreCase("null")){
                    Intent intent = new Intent(SplashScreen.this, StartedActivity.class);
                    SplashScreen.this.startActivity(intent);
                }
                else if(token.equalsIgnoreCase(SharedPrefUtils.getStringSharedPref("token", "null")) && SharedPrefUtils.getIntSharedPref("id_team", 0) == 0 ){
                    Intent intent = new Intent(SplashScreen.this, HomeFragment.class);
                    SplashScreen.this.startActivity(intent);
                }
                else{
                    Intent intent = new Intent(SplashScreen.this, NavigationActivity.class);
                    SplashScreen.this.startActivity(intent);
                }
//                Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
//                SplashScreen.this.startActivity(intent);
                SplashScreen.this.finish();
            }
        }, DELAY);
    }

    @Override
    public void moveToLogin() {

    }

    @Override
    public void moveToHome() {

    }

    @Override
    public void loading() {

    }
}
