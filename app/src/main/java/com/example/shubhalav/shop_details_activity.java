package com.example.shubhalav;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class shop_details_activity extends AppCompatActivity {



    Button savebutton ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_details);

        savebutton = findViewById(R.id.save_btn);

        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(shop_details_activity.this,summarylayout_activity.class);
                startActivity(intent);
            }
        });


//



    }
}
