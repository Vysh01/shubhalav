package com.example.shubhalav;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.shubhalav.remote.UserService;

public class loginactivity extends AppCompatActivity {





    EditText edtphonenumber, edtpassword;
    Button login ;
    UserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        edtphonenumber = findViewById(R.id.edtphonenumber);
        edtpassword = findViewById(R.id.edtpassword);
        login = findViewById(R.id.lgn_btn);
        userService = ApiUtilis.getUserService();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





            }
        });


    }




}
