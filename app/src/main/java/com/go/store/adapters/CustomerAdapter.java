package com.go.store.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.go.store.AddItemActivity;
import com.go.store.R;
import com.go.store.beans.Customer;

import java.util.ArrayList;

/*
 * Created by Rishav on 8/9/2017.
 */

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Customer> customersList;

    public CustomerAdapter(Context context, ArrayList<Customer> customersList) {
        this.context = context;
        this.customersList = customersList;
    }

    @Override
    public CustomerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_customers, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomerAdapter.ViewHolder holder, int position) {
        Customer customer = customersList.get(position);
        String name = customer.getName();
        String address = customer.getAddress();
        String contact = customer.getContact();
        String contact_opt = customer.getContact_optional();

        holder.tvName.setText(name);
        holder.tvAddress.setText(address);
        holder.tvContact.setText(contact);
        holder.tvContactOpt.setText(contact_opt);

        if (contact_opt.isEmpty())
            holder.tvContactOpt.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return customersList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvName, tvAddress, tvContact, tvContactOpt;

        ViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvAddress = (TextView) itemView.findViewById(R.id.tvAddress);
            tvContact = (TextView) itemView.findViewById(R.id.tvContact);
            tvContactOpt = (TextView) itemView.findViewById(R.id.tvContactOpt);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            context.startActivity(new Intent(context, AddItemActivity.class)
            .putParcelableArrayListExtra("list", customersList)
            .putExtra("position", getAdapterPosition()));
        }
    }
}
