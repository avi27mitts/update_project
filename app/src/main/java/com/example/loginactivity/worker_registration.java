package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class worker_registration extends AppCompatActivity {


    Button btnsubmit ,btnnext ;

    EditText etname , etaadhar ;

    Spinner spnwork ;

    ListView lvdisplay ;

    List<worker_registration> workerlist ;

    DatabaseReference dbWorker ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_registration);


        btnsubmit = findViewById(R.id.btn_submit) ;
        btnnext = findViewById(R.id.btn_next) ;

        etaadhar = findViewById(R.id.et_aadhar) ;
        etname = findViewById(R.id.et_name) ;

        spnwork = findViewById(R.id.spn_work) ;

        dbWorker = FirebaseDatabase.getInstance().getReference("workers") ;

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addWorker() ;

            }
        });

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Intent intent = new Intent( getApplicationContext() , display.class ) ;
                startActivity(intent) ;
                */
            }
        });

    }


    private void addWorker(){

        String name = etname.getText().toString().trim() ;
        String aadhar = etaadhar.getText().toString().trim() ;
        String work = spnwork.getSelectedItem().toString() ;

        if( name.isEmpty() || aadhar.isEmpty() ){

            Toast.makeText( getApplicationContext() , "Please enter details properly . " , Toast.LENGTH_SHORT).show() ;

        }
        else {

            String id = dbWorker.push().getKey() ;

            worker_details w = new worker_details( name , aadhar , work ) ;

            dbWorker.child(id).setValue(w) ;

            Toast.makeText( getApplicationContext() , "Worker added . " , Toast.LENGTH_SHORT).show() ;

        }

    }

}
