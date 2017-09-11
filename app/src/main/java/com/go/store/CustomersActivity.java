package com.go.store;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.go.store.adapters.CustomerAdapter;
import com.go.store.beans.Customer;

import java.util.ArrayList;

public class CustomersActivity extends BaseActivity {

    DBHelper dbHelper;
    ArrayList<Customer> customersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers);

        initViews();
    }

    public void initViews() {
        dbHelper = new DBHelper(this);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        customersList = dbHelper.getCustomerDetails();

        if (customersList.size() == 0) {
            Toast.makeText(this, "No customer found", Toast.LENGTH_SHORT).show();
        }

        CustomerAdapter customerAdapter = new CustomerAdapter(this, customersList);
        recyclerView.setAdapter(customerAdapter);
    }
}