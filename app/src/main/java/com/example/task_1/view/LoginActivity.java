package com.example.task_1.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.task_1.enums.AuthType;
import com.example.task_1.Constants;
import com.example.task_1.R;

import static com.example.task_1.enums.AuthType.*;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mRegisterButton;
    private Button mLoginButton;

    private EditText mPasswordEditText;
    private EditText mEmailEditTExt;

    private String mLogin;
    private String mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        findViews();
        setClickListeners();
    }

    public void findViews() {
        mRegisterButton = findViewById(R.id.registerButton);
        mLoginButton = findViewById(R.id.loginButton);
        mEmailEditTExt = findViewById(R.id.emailEditTExt);
        mPasswordEditText = findViewById(R.id.passwordEditText);
    }

    public void setClickListeners() {
        mRegisterButton.setOnClickListener(this);
        mLoginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.loginButton) {
            auth(LOGIN);
        } else if (view.getId() == R.id.registerButton) {
            auth(REGISTER);
        }
    }

    private void auth(AuthType authType) {
        mLogin = mEmailEditTExt.getText().toString();
        mPassword = mPasswordEditText.getText().toString();
        if (!mLogin.isEmpty() && !mPassword.isEmpty()) {
            Intent intent = getIntent(authType, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Enter login and password", Toast.LENGTH_LONG).show();
        }
    }

    private Intent getIntent(AuthType authType, Class clazz) {
        Intent intent = new Intent(getApplicationContext(), clazz);
        String authTypeText = authType == LOGIN ? LOGIN.name() : REGISTER.name();
        intent.putExtra(Constants.AUTH_TYPE_KEY, authTypeText);
        intent.putExtra(Constants.LOGIN_KEY, mLogin);
        intent.putExtra(Constants.PASSWORD_KEY, mPassword);
        return intent;
    }
}