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

        inputNameSignup = findViewById(R.id.inputNameSignUp);
        inputEmailSignup = findViewById(R.id.inputEmailSignup);
        inputPasswordSignup = findViewById(R.id.inputPasswordSignup);
        inputConfirmPasswordSignup = findViewById(R.id.inputConfirmPasswordSignup);

        buttonSignup = findViewById(R.id.buttonSignup);
        txtsignupforlogin = findViewById(R.id.txtsignupforlogin);

        progressDialog = new ProgressDialog(this);
        registerPresenter = new RegisterPresenter(this);

        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = inputNameSignup.getText().toString();
                String email = inputEmailSignup.getText().toString();
                String password = inputPasswordSignup.getText().toString();
                String cPassword = inputConfirmPasswordSignup.getText().toString();

                if(inputNameSignup.getText().length() == 0 || inputEmailSignup.getText().length() == 0 ||
                        inputPasswordSignup.getText().length() == 0 ||
                        inputConfirmPasswordSignup.getText().length() == 0){
                    registerPresenter.showError();
                }
                else{
                    registerPresenter.registrationUser(name, email, password, cPassword);
                }
            }
        });
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
