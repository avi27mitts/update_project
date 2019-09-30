package com.example.loginactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity implements View.OnClickListener {

    private Button btnLogin;
    private Button btnRegister;
    private EditText tvemail;
    private EditText tvpassword;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setting default screen to login.xml
        setContentView(R.layout.activity_login);
        btnLogin=(Button) findViewById(R.id.btnLogin);
        tvemail=(EditText) findViewById(R.id.tvemail);
        tvpassword=(EditText) findViewById(R.id.tvpassword);
        btnRegister=(Button) findViewById(R.id.btnRegister);
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){
        if(view==btnLogin){
            registerUser()
        }
        if ()
    }


}