package com.example.shubhalav;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.example.shubhalav.AdaptorShopList.ShopListAdapter;
import com.example.shubhalav.model.ShopModel;
import com.example.shubhalav.remote.RetrofitClient;

import java.util.ArrayList;
import java.util.HashMap;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShopListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_recycler);
        recyclerView = findViewById(R.id.shop_list_recycler);

        sharedPreferences = getSharedPreferences(Constants.SP_NAME, MODE_PRIVATE);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        HashMap<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Token " + getToken());

        Call<ArrayList<ShopModel>> modelclasscall = RetrofitClient.getInstance().getApi().Shopdetails(headers);
        modelclasscall.enqueue(new Callback<ArrayList<ShopModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ShopModel>> call, Response<ArrayList<ShopModel>> response) {
                ArrayList shopList = response.body();
                recyclerView.setAdapter(new ShopListAdapter(shopList));


            }

            @Override
            public void onFailure(Call<ArrayList<ShopModel>> call, Throwable t) {
                Log.d("mylog", "Error: " + t.getMessage());
            }
        });
    }

    private String getToken() {
        return sharedPreferences.getString(Constants.spToken, "");
    }
}
