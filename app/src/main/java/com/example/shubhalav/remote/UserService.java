package com.example.shubhalav.remote;

import com.example.shubhalav.model.ResObj;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserService {

    @GET("login/{Phone Number}/{password}")
    Call<ResObj>
    login(@Path("Phone Number") String phone_no,
          @Path("password") String password);
}
