package com.example.shubhalav.model;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class LoginResponse {

    private boolean error ;
    private ArrayList<User> user ;
    private String token;


    public boolean isError() {
        return error;
    }



    public String getToken() {
        return token;
    }
}



