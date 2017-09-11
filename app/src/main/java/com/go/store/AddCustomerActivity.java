package com.go.store;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.go.store.beans.Customer;

public class AddCustomerActivity extends BaseActivity implements View.OnClickListener{

    TextView tvAddCustomer;
    EditText editName, editAddress, editContact, editContactOptional;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);

        initViews();
    }

    public void initViews() {
        dbHelper = new DBHelper(this);
        editName = (EditText) findViewById(R.id.editName);
        editAddress = (EditText) findViewById(R.id.editAddress);
        editContact = (EditText) findViewById(R.id.editContact);
        editContactOptional = (EditText) findViewById(R.id.editContactOptional);

        tvAddCustomer = (TextView) findViewById(R.id.tvAddCustomer);
        tvAddCustomer.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvAddCustomer:

                String name = editName.getText().toString().trim();
                String address = editAddress.getText().toString().trim();
                String contact = editContact.getText().toString().trim();
                String contact_opt = editContactOptional.getText().toString().trim();

                if (name.isEmpty())
                    editName.setError("Required");
                else if (address.isEmpty())
                    editAddress.setError("Required");
                else if (contact.isEmpty())
                    editContact.setError("Required");
                else {
                    Customer customer = new Customer(name, address, contact, contact_opt);
                    long insert = dbHelper.insertData(customer);
                    if (insert >= 1) {
                        Toast.makeText(this, "Customer added", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Failed to add customer. Please try again", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    startActivity(new Intent(this, AddItemActivity.class));
                }

                break;
        }
    }
}