package com.example.shubhalav;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class itemListActivity extends AppCompatActivity {


    TextView no, title , body;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_list_layout);

        no = findViewById(R.id.no);
        title = findViewById(R.id.title);
        body= findViewById(R.id.body);

        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(itemListActivity.this, ShopDetailsActivity.class);
                startActivity(intent);
            }
        });
    }
}
