package com.example.shubhalav.remote;

import androidx.recyclerview.widget.RecyclerView;

import com.example.shubhalav.model.LoginResponse;
import com.example.shubhalav.model.Shop_details;
import com.example.shubhalav.model.User;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {



    @POST("login/")
    Call<LoginResponse> login(@Body RequestBody body);

    @GET("shop/")
    Call<Shop_details> Shopdetails();
}
