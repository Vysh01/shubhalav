package com.example.shubhalav.remote;

import com.example.shubhalav.model.LoginResponse;
import com.example.shubhalav.model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {


    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> userLogin(
            @Field("mobile_no") String mobile_no,
            @Field("password") String password);
}
