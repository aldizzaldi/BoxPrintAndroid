package com.example.boxprintandroid.ui.login;

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
import com.example.boxprintandroid.activity.MainActivity;
import com.example.boxprintandroid.data.LoginPresenter;

import java.security.cert.CertPathBuilderSpi;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    EditText email, password;
    TextView button_to_signup;
    Button btnLogin;
    private LoginPresenter presenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.inputEmail);
        password = findViewById(R.id.inputPassword);
        button_to_signup = findViewById(R.id.button_to_signup);
        btnLogin = findViewById(R.id.buttonLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = email.getText().toString();
                String pwd = password.getText().toString();
                if(email.getText().length() == 0){
                    presenter.showError();
                }
                else{
                    presenter.doLogin(username,pwd);
                }
            }
        });

    }

    @Override
    public void moveToHomepage() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        LoginActivity.this.finish();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
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

    @Override
    public void showError() {

    }

}
