package com.example.shubhalav.model;

public class LoginResponse {

    private boolean error ;
    private String user, token;

    public LoginResponse(boolean error, String user, String token) {
        this.error = error;
        this.user = user;
        this.token = token;
    }


    public boolean isError() {
        return error;
    }

    public String getUser() {
        return user;
    }

    public String getToken() {
        return token;
    }
}



