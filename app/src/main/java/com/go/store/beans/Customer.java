package com.go.store.beans;

/*
 * Created by Rishav on 8/9/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

public class Customer implements Parcelable{
    private String name, address, contact, contact_optional;

    public Customer() {

    }

    public Customer(String name, String address, String contact, String contact_optional) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.contact_optional = contact_optional;
    }

    private Customer(Parcel in) {
        name = in.readString();
        address = in.readString();
        contact = in.readString();
        contact_optional = in.readString();
    }

    public static final Creator<Customer> CREATOR = new Creator<Customer>() {
        @Override
        public Customer createFromParcel(Parcel in) {
            return new Customer(in);
        }

        @Override
        public Customer[] newArray(int size) {
            return new Customer[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }

    public String getContact_optional() {
        return contact_optional;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setContact_optional(String contact_optional) {
        this.contact_optional = contact_optional;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(address);
        parcel.writeString(contact);
        parcel.writeString(contact_optional);
    }
}
