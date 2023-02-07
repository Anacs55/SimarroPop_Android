package com.crmeoj.simarropop.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.crmeoj.simarropop.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etLoginUser;
    private EditText etLoginPassword;
    private Button btnLoginRegister;
    private Button btnLoginStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLoginUser = (EditText) findViewById(R.id.etLoginUser);
        etLoginPassword = (EditText) findViewById(R.id.etLoginPassword);
        btnLoginRegister = (Button) findViewById(R.id.btnLoginRegister);
        btnLoginStart = (Button) findViewById(R.id.btnLoginStart);

        btnLoginRegister.setOnClickListener(this::onClick);
        btnLoginStart.setOnClickListener(this::onClick);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnLoginRegister:

                Intent i1 = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i1);

                break;

            case R.id.btnLoginStart:

                Intent i2 = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i2);

                break;

        }

    }
}