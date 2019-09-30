package com.example.loginactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends Activity {

    Button btnlogin , btnregister ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setting default screen to login.xml
        setContentView(R.layout.activity_login);

        btnregister = findViewById(R.id.btnRegister);
        btnlogin = findViewById(R.id.btnLogin);

        // Listening to register new account link
        btnregister.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Switching to Register screen
                Intent i = new Intent( LoginActivity.this , RegisterActivity.class) ;
                startActivity(i);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Switching to Register screen
                Intent i = new Intent( getApplicationContext() , options.class) ;
                startActivity(i);
            }
        });

    }
}