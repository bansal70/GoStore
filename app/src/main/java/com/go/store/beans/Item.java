package com.go.store.beans;

import android.os.Parcel;
import android.os.Parcelable;

/*
 * Created by Rishav on 8/8/2017.
 */

public class Item implements Parcelable {
    private String itemName, itemQuantity, itemPrice;

    public Item(String itemName, String itemQuantity, String itemPrice) {
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
    }

    private Item(Parcel in) {
        itemName = in.readString();
        itemQuantity = in.readString();
        itemPrice = in.readString();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public String getItemName() {
        return itemName;
    }

    public String getItemQuantity() {
        return itemQuantity;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(itemName);
        parcel.writeString(itemQuantity);
        parcel.writeString(itemPrice);
    }
}
