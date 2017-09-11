package com.go.store;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.go.store.beans.Item;

import java.util.ArrayList;

public class AddItemActivity extends BaseActivity implements View.OnClickListener {

    EditText editItem, editQuantity, editPrice;
    TextView tvAddItem, tvProceed;
    private ArrayList<Item> itemsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        initViews();
    }

    public void initViews() {
        itemsList = new ArrayList<>();
        editItem = (EditText) findViewById(R.id.editItem);
        editQuantity = (EditText) findViewById(R.id.editQuantity);
        editPrice = (EditText) findViewById(R.id.editPrice);

        tvAddItem = (TextView) findViewById(R.id.tvAddItem);
        tvProceed = (TextView) findViewById(R.id.tvProceed);

        tvAddItem.setOnClickListener(this);
        tvProceed.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvAddItem:

                Item item = new Item(editItem.getText().toString(),
                        editQuantity.getText().toString(),
                        editPrice.getText().toString());

                itemsList.add(item);

                Toast.makeText(this, "Item added successfully..", Toast.LENGTH_SHORT).show();
                break;

            case R.id.tvProceed:
                startActivity(new Intent(this, ItemsActivity.class)
                .putParcelableArrayListExtra("list", itemsList));
                break;
        }
    }
}
