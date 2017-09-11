package com.go.store;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.go.store.adapters.ItemsAdapter;
import com.go.store.beans.Item;

import java.util.ArrayList;

public class ItemsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        initViews();
    }

    public void initViews() {
        ArrayList<Item> itemsList = getIntent().getParcelableArrayListExtra("list");
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        ItemsAdapter itemsAdapter = new ItemsAdapter(this, itemsList);
        recyclerView.setAdapter(itemsAdapter);
    }
}
