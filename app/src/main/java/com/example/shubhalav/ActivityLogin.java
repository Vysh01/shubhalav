package com.example.shubhalav;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
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

public class ActivityLogin extends AppCompatActivity {


    EditText edt_phonenumber, edt_password;
    Button login;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        edt_phonenumber = findViewById(R.id.ID_phone_number);
        edt_password = findViewById(R.id.ID_password);
        login = findViewById(R.id.lgn_btn);
        dialog = new ProgressDialog(this);
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);
        dialog.setMessage("Logging in");


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();

            }
        });
    }

    private void userLogin() {

        String mobile_no = edt_phonenumber.getText().toString().trim();
        String password = edt_password.getText().toString().trim();


        if (TextUtils.isEmpty(mobile_no)) {
            Toast.makeText(this, "Mobile number cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        dialog.show();
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
                Log.d("mylog", "Got Resp:" + response.toString());
                if (loginResponse == null) {
                    Toast.makeText(ActivityLogin.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!loginResponse.isError()) {
                    Intent intent = new Intent(ActivityLogin.this, ShopListActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    SharedPreferences sp = getSharedPreferences(Constants.SP_NAME, MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString(Constants.spToken, loginResponse.getToken());
                    editor.putInt(Constants.userId, loginResponse.getUser().getId());
                    editor.commit();
                    Toast.makeText(ActivityLogin.this, "Login Successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ActivityLogin.this, "Login Failed, Username or Password incorrect", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.d("mylog", "Error: " + t.getMessage());
            }
        });

    }


}
