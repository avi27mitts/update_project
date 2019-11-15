package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Customer_Signup extends AppCompatActivity {

    TextView tvname;
    EditText etname;
    TextView tvemail;
    EditText etemail;
    TextView tvpassword;
    EditText etpassword;
    TextView tvphone;
    EditText etphone;
    Button bsignup;
    DatabaseReference databasecustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer__signup);

        databasecustomer= FirebaseDatabase.getInstance().getReference("fsignup");

        etname= (EditText)findViewById(R.id.etname);
        etemail= (EditText)findViewById(R.id.etemail);
        etpassword =(EditText) findViewById(R.id.etpassword);
        etphone= (EditText) findViewById(R.id.etphone);
        bsignup = findViewById(R.id.bsignup) ;

        bsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addcustomer() ;

            }
        });
    }

    private void addcustomer(){
        String name =etname.getText().toString().trim();
        String email =etemail.getText().toString().trim();
        String password =etpassword.getText().toString().trim();
        String phone =etphone.getText().toString().trim();

        if(TextUtils.isEmpty(name)  || TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(phone) ){
            Toast.makeText(this,"Please Fill Your Entries correctly",Toast.LENGTH_LONG).show();

        }

        else {

            String id= databasecustomer.push().getKey();

            fsignup cust = new fsignup(name,email,password,phone);

            databasecustomer.child(id).setValue(cust);

            Toast.makeText(this,"Customer Added",Toast.LENGTH_LONG).show();

            Intent intent = new Intent(getApplicationContext() , options.class) ;
            startActivity(intent) ;
        }


    }
}
