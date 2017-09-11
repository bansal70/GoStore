package com.go.store;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    TextView addCustomer, oldCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    public void initViews() {
        addCustomer = (TextView) findViewById(R.id.addCustomer);
        oldCustomer = (TextView) findViewById(R.id.oldCustomer);

        addCustomer.setOnClickListener(this);
        oldCustomer.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.addCustomer:
                startActivity(new Intent(this, AddCustomerActivity.class));
                break;

            case R.id.oldCustomer:
                startActivity(new Intent(this, CustomersActivity.class));
                break;
        }
    }
}
