package com.example.shubhalav.remote;

import com.example.shubhalav.model.LoginResponse;
import com.example.shubhalav.model.ShopModel;
import com.example.shubhalav.model.SurveyDetail;

import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;

public interface Api {
    @POST("login/")
    Call<LoginResponse> login(@Body RequestBody body);

    @GET("shop/")
    Call<ArrayList<ShopModel>> Shopdetails(@HeaderMap HashMap<String, String> headers);

    @Multipart
    @POST("survey/")
    Call<SurveyDetail> surveyDetail(@Body RequestBody body1);


}
