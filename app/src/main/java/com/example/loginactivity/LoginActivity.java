package com.example.loginactivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends Activity implements View.OnClickListener {

    private Button Login;
    private Button Register;
    private EditText emal;
    private EditText pswd;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setting default screen to login.xml
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        Login=(Button) findViewById(R.id.btnLogin);
        emal=(EditText) findViewById(R.id.tvemail);
        pswd=(EditText) findViewById(R.id.tvpassword);
        Register=(Button) findViewById(R.id.btnRegister);
        Login.setOnClickListener(this);
        Register.setOnClickListener(this);

    }

    private void registerUser(){
        String emai = emal.getText().toString().trim() ;
        String psswd = pswd.getText().toString().trim();

        if (TextUtils.isEmpty(emai)) {
            // Email is empty
            Toast.makeText(this, "Please Enter Email",Toast.LENGTH_SHORT).show();
            // stop from Further
            return;
        }

        if (TextUtils.isEmpty(psswd)) {
            // Password is empty
            Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show();
            // stop from further
            return;
        }

        // If correct enter

        progressDialog.setMessage("Registering User");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(emai,psswd)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<com.google.firebase.auth.AuthResult> task) {
                        if (task.isSuccessful()) {
                            // user is successfully registered 
                            Toast.makeText(LoginActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(LoginActivity.this, "Registration Failed ! Please try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                })


    }

    @Override
    public void onClick(View view){
        if(view==Login){
            registerUser()
        }

    }


}