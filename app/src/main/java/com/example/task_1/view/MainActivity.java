package com.example.task_1.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.task_1.Constants;
import com.example.task_1.R;

public class MainActivity extends AppCompatActivity {

    private TextView mLoginTextView;
    private TextView mPasswordTextView;

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        if (getSupportActionBar() != null) {
            setSupportActionBar(mToolbar);
        }
        setData(getIntent());
    }

    public void findViews() {
        mToolbar = findViewById(R.id.toolBar);
        mLoginTextView = findViewById(R.id.loginTextView);
        mPasswordTextView = findViewById(R.id.passwordTextView);
    }

    private void setData(Intent intent) {
        if (intent.hasExtra(Constants.AUTH_TYPE_KEY)) {
            mToolbar.setTitle(intent.getStringExtra(Constants.AUTH_TYPE_KEY));
        }
        if (intent.hasExtra(Constants.LOGIN_KEY)) {
            mLoginTextView.setText(intent.getStringExtra(Constants.LOGIN_KEY));
        }
        if (intent.hasExtra(Constants.PASSWORD_KEY)) {
            mPasswordTextView.setText(intent.getStringExtra(Constants.PASSWORD_KEY));
        }
    }
}