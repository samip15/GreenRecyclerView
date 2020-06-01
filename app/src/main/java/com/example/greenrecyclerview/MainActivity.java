package com.example.greenrecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements GreenAdapter.ListClickListner {

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
        adapter = new GreenAdapter(NUMBER_LIST_ITEM,this);
        mnumberList.setAdapter(adapter);

    }
    /*  ------------------------------MENU--------------------
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId){
            case R.id.action_refresh:
                adapter = new GreenAdapter(NUMBER_LIST_ITEM,this);
                mnumberList.setAdapter(adapter);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {

        String toastMessage = "Item#" + clickedItemIndex + "Clicked";
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();

    }
}