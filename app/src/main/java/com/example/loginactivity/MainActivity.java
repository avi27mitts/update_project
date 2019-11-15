package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_customer_login , btn_worker_login , btn_admin ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_customer_login=(Button)findViewById(R.id.btn_customer_login);
        btn_worker_login=(Button)findViewById(R.id.btn_worker_login);
        btn_admin = findViewById(R.id.btn_admin) ;

        btn_customer_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Customer_Sign_in.class);
                startActivity(intent);
            }
        });

        btn_worker_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent( getApplicationContext() , Salary_page.class );
                startActivity(intent);
            }
        });

        btn_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext() ,Customer_Signup.class) ;
                startActivity(intent) ;

                //Toast.makeText(this , "button clicked" , Toast.LENGTH_LONG).show() ;
            }
        });

    }

}
