package com.go.store;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.go.store.beans.Customer;

import java.util.ArrayList;

/*
 * Created by Rishav on 8/9/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_sales";
    private static final String TABLE_NAME = "sales";
    private static final String KEY_ID = "id";
    private final String CUSTOMER_NAME = "name";
    private final String CUSTOMER_ADDRESS = "address";
    private final String CUSTOMER_CONTACT = "contact";
    private final String CUSTOMER_CONTACT_OPTIONAL = "contact_optional";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CUSTOMER_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + CUSTOMER_NAME + " TEXT," +
                CUSTOMER_ADDRESS + " TEXT," + CUSTOMER_CONTACT + " TEXT," + CUSTOMER_CONTACT_OPTIONAL + " TEXT)" ;

        db.execSQL(CREATE_CUSTOMER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME );
    }

    public long insertData(Customer customer) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CUSTOMER_NAME, customer.getName());
        values.put(CUSTOMER_ADDRESS, customer.getAddress());
        values.put(CUSTOMER_CONTACT, customer.getContact());
        values.put(CUSTOMER_CONTACT_OPTIONAL, customer.getContact_optional());

        long cnt = db.insert(TABLE_NAME, null, values);
        db.close();
        return cnt;
    }

    public ArrayList<Customer> getCustomerDetails() {
        ArrayList<Customer> dataList = new ArrayList<>();
        String query = "select * from " + TABLE_NAME;
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                Customer customer = new Customer();
                customer.setName(cursor.getString(1));
                customer.setAddress(cursor.getString(2));
                customer.setContact(cursor.getString(3));
                customer.setContact_optional(cursor.getString(4));
                dataList.add(customer);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return dataList;
    }

}
