package com.example.shubhalav.AdaptorShopList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shubhalav.AdaptorShopList.modelclass;
import com.example.shubhalav.R;
import com.example.shubhalav.model.Shop_details;
import com.example.shubhalav.remote.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class item_list_recyclerActivity extends AppCompatActivity {



    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_recycler);
        recyclerView = findViewById(R.id.shop_list_recycler);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);



        List<modelclass> modelclassList = new ArrayList<>();



      Call<Shop_details> modelclasscall = RetrofitClient.getInstance().getApi().Shopdetails();
        modelclasscall.enqueue(new Callback<Shop_details>() {
            @Override
            public void onResponse(Call<Shop_details> call, Response<Shop_details> response) {
                Shop_details shop_details = response.body();


//                recyclerView.setAdapter(new itemAdaptor(item_list_recyclerActivity.this,List<modelclass>));
//                itemAdaptor itemAdaptor1 = new itemAdaptor(modelclassList);
//               recyclerView.setAdapter(itemAdaptor1);

                Toast.makeText(item_list_recyclerActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Shop_details> call, Throwable t) {

                Toast.makeText(item_list_recyclerActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });


//




    }




}
