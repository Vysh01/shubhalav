package com.example.shubhalav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shubhalav.model.LoginResponse;
import com.example.shubhalav.remote.Api;
import com.example.shubhalav.remote.RetrofitClient;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class loginactivity extends AppCompatActivity {


    EditText edtphonenumber, edtpassword;
    Button login;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        edtphonenumber = findViewById(R.id.edtphonenumber);
        edtpassword = findViewById(R.id.edtpassword);
        login = findViewById(R.id.lgn_btn);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent = new Intent(loginactivity.this,item_list_activity.class);
//                startActivity(intent);
                userLogin();
            }
        });


    }


    private void userLogin() {

        String mobile_no = edtphonenumber.getText().toString().trim();
        String password = edtpassword.getText().toString().trim();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(mobile_no, mobile_no);
        editor.putString(password, password);
        editor.apply();

//    Call<LoginResponse> call = RetrofitClient.getInstance().getApi().userLogin(mobile_no,password);
//
//    call.enqueue(new Callback<LoginResponse>() {
//        @Override
//        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
//            LoginResponse loginResponse = response.body();
//
//            if (!loginResponse.isError()) {
//
//                Toast.makeText(loginactivity.this, loginResponse.getToken(), Toast.LENGTH_SHORT).show();
//
//            }else {
//                Toast.makeText(loginactivity.this, "error", Toast.LENGTH_SHORT).show();
//            }
//        }
//
//        @Override
//        public void onFailure(Call<LoginResponse> call, Throwable t) {
//
//        }
//    });

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("username", mobile_no)
                .addFormDataPart("password", password)
                .build();
//            Api.login(requestBody).enqueue(new Callback<TokenModel>()


    }
}

