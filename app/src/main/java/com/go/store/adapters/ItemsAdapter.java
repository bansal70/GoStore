package com.go.store.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.go.store.R;
import com.go.store.beans.Item;

import java.util.ArrayList;

/*
 * Created by Rishav on 8/8/2017.
 */

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Item> itemsList;

    public ItemsAdapter(Context context, ArrayList<Item> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @Override
    public ItemsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.view_items, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemsAdapter.ViewHolder holder, int position) {
        Item item = itemsList.get(position);

        String str_item = "Item: " + item.getItemName();
        String str_qty = "Quantity: " + item.getItemQuantity();
        String str_price = "Price: " + item.getItemPrice();

        holder.tvItem.setText(str_item);
        holder.tvItemQuantity.setText(str_qty);
        holder.tvItemPrice.setText(str_price);
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvItem, tvItemQuantity, tvItemPrice;
        private ImageView imgEdit, imgDelete;

        public ViewHolder(View itemView) {
            super(itemView);

            tvItem = (TextView)itemView.findViewById(R.id.tvItem);
            tvItemQuantity = (TextView)itemView.findViewById(R.id.tvItemQuantity);
            tvItemPrice = (TextView)itemView.findViewById(R.id.tvItemPrice);

            imgEdit = (ImageView)itemView.findViewById(R.id.imgEdit);
            imgDelete = (ImageView)itemView.findViewById(R.id.imgDelete);
        }
    }
}
