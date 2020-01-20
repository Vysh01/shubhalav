package com.example.shubhalav.remote;

public class ApiUtilis {

    public static final String BASE_URL = "192.168.1.30:8000/login";

    public static UserService getUserService() {
        return RetrofitClient.getClient(BASE_URL).create(UserService.class);
    }

}
