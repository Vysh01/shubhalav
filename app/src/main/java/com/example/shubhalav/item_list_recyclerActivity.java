//package com.example.shubhalav;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class item_list_recyclerActivity extends AppCompatActivity {
//
//
//
//    private RecyclerView recyclerView;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.item_list_recycler);
//
//
//
//
//        recyclerView = findViewById(R.id.recycler_view);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(layoutManager);
//
//        List<modelclass> modelclassList = new ArrayList<>();
//        modelclassList.add(new modelclass("#122", "Shree Kirana Pasal", "Thapagaun, Baneswor"));
//        modelclassList.add(new modelclass("#123", "Krishna Kirana Pasal", "Thapagaun, Baneswor"));
//        modelclassList.add(new modelclass("#124", "Nuwakot Khadyana Bhandar", "Thapagaun, Baneswor"));
//        modelclassList.add(new modelclass("#125", "Rita Tarkari Pasal", "Thapagaun, Baneswor"));
//        modelclassList.add(new modelclass("#127", "Hariya Store", "Thapagaun, Baneswor"));
//        modelclassList.add(new modelclass("#128", "Laxman Cold Store", "Thapagaun, Baneswor"));
//
//       itemAdaptor itemAdaptor1 = new itemAdaptor(modelclassList);
//       recyclerView.setAdapter(itemAdaptor1);
//
//
//
//
//    }
//
//
//
//
//}
