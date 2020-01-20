package com.example.shubhalav.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {


    public static Retrofit retrofit = null;

    public static Retrofit getClient(String baseUrl){

        if(retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://192.168.1.30:8000/login/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
