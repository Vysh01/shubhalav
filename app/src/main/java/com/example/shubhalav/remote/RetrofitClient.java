package com.example.shubhalav.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {


    public static final String BASE_URL = "192.168.1.30:8000/login";
    public static Retrofit retrofit = null;

    public static Retrofit getRetrofitClient(){

        if(retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
