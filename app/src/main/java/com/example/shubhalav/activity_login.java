package com.example.shubhalav;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shubhalav.model.LoginResponse;
import com.example.shubhalav.remote.RetrofitClient;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class activity_login extends AppCompatActivity {



    EditText edt_phonenumber, edt_password;
    Button login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);


        edt_phonenumber = findViewById(R.id.ID_phone_number);
        edt_password = findViewById(R.id.ID_password);
        login = findViewById(R.id.lgn_btn);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();

                Intent intent = new Intent(activity_login.this,item_list_activity.class);
                startActivity(intent);
            }
        });

    }

    private void userLogin() {

        String mobile_no = edt_phonenumber.getText().toString().trim();
        String password = edt_password.getText().toString().trim();


        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("mobile_no", mobile_no)
                .addFormDataPart("password", password)
                .build();


        Call<LoginResponse> call = RetrofitClient.getInstance().getApi().login(requestBody);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();
                Log.d("mylog", "Got Resp");
                if (!loginResponse.isError()) {
                    Toast.makeText(activity_login.this, loginResponse.getToken(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(activity_login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {


                Log.d("mylog", "Error: " + t.getMessage());
            }
        });

    }


}
