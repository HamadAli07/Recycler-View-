package com.example.recyclerview191071;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    List<String> cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cities=new ArrayList<>();
        recyclerView=findViewById(R.id.RV);
        recyclerAdapter=new RecyclerAdapter(cities);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);
        cities.add("Islamabad");
        cities.add("Lahore");
        cities.add("Karachi");
        cities.add("Multan");
        cities.add("Peshawar");
        cities.add("Quetta");
        cities.add("Rawalpindi");
        cities.add("Faisalabad");
        cities.add("Abbotabad");
        cities.add("Sargodha");

        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }
}