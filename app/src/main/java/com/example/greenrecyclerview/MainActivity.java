package com.example.greenrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mnumberList;
    private static final int NUMBER_LIST_ITEM = 100;
    private GreenAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mnumberList = findViewById(R.id.iv_numbers);
        // layout manager (linear layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mnumberList.setLayoutManager(linearLayoutManager);
        //to improve profrence of rv
        mnumberList.setHasFixedSize(true);
        //setAdapter
        adapter = new GreenAdapter(NUMBER_LIST_ITEM);
        mnumberList.setAdapter(adapter);

    }
}