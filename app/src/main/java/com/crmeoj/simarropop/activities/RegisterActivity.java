package com.crmeoj.simarropop.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;

import com.crmeoj.simarropop.R;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etRegisterName;
    private EditText etRegisterEmail;
    private EditText etRegisterPassword;
    private CheckBox cbRegister;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etRegisterName = (EditText) findViewById(R.id.etRegisterName);
        etRegisterEmail = (EditText) findViewById(R.id.etRegisterEmail);
        etRegisterPassword = (EditText) findViewById(R.id.etLoginPassword);
        cbRegister = (CheckBox) findViewById(R.id.cbRegister);
        btnRegister = (Button) findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(this::onClick);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnRegister:

                Intent i1 = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(i1);

                break;

        }

    }
}