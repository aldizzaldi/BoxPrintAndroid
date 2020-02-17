package com.example.boxprintandroid.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.boxprintandroid.R;
import com.example.boxprintandroid.data.LoginPresenter;
import com.example.boxprintandroid.data.RegisterPresenter;
import com.example.boxprintandroid.ui.IRegisterView;

public class SignupActivity extends AppCompatActivity implements IRegisterView {

    EditText inputNameSignup, inputEmailSignup, inputPasswordSignup, inputConfirmPasswordSignup;
    Button buttonSignup;
    TextView txtsignupforlogin;

    private RegisterPresenter registerPresenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        inputNameSignup = findViewById(R.id.inputNameSignup);
        inputEmailSignup = findViewById(R.id.inputEmailSignup);
        inputPasswordSignup = findViewById(R.id.inputPasswordSignup);
        inputConfirmPasswordSignup = findViewById(R.id.inputConfirmPasswordSignup);

        buttonSignup = findViewById(R.id.buttonSignup);
        txtsignupforlogin = findViewById(R.id.txtsignupforlogin);

        progressDialog = new ProgressDialog(this);
        registerPresenter = new RegisterPresenter(this);
    }

    @Override
    public void showLogin() {
        Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getApplicationContext(), message , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        progressDialog.setMessage("Loading");
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.dismiss();
    }

}
