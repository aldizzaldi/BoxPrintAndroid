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
import com.example.boxprintandroid.interfaces.ILoginView;


public class LoginActivity extends AppCompatActivity implements ILoginView {
    EditText emailLogin, passwordLogin;
    Button buttonLogin;
    TextView button_to_signup;

    private LoginPresenter loginPresenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttonLogin = findViewById(R.id.buttonLogin);
        button_to_signup = findViewById(R.id.questionOnLogin);
        emailLogin = findViewById(R.id.inputEmailLogin);
        passwordLogin = findViewById(R.id.inputPasswordLogin);

        progressDialog = new ProgressDialog(this);
        loginPresenter = new LoginPresenter(this);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = emailLogin.getText().toString();
                String password = passwordLogin.getText().toString();

                if(emailLogin.getText().length() == 0 || passwordLogin.getText().length() == 0){
                    loginPresenter.showError();
                }
                else{
                    loginPresenter.doLogin(username,password);
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
        Toast.makeText(getApplicationContext(), message , Toast.LENGTH_LONG).show();
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


