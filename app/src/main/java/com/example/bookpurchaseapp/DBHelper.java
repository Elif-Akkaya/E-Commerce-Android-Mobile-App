package com.example.bookpurchaseapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bookpurchaseapp.models.Favorite_Model;
import com.example.bookpurchaseapp.models.Order_Model;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    final static String DBNAME = "bookapplication.db";
    final static int DBVERSION = 2;

    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table orders" + "(order_no integer primary key autoincrement," + "name_surname text," + "address text," + "phone text," + "price int," + "quantity int," + "image int," + "book_name text," + "author_name text," + "description int," + "language text)");
        db.execSQL("create table favorites" + "(id integer primary key autoincrement," + "name_surname text," + "phone text," + "price int," + "image int," + "book_name text," + "author_name text," + "description int," + "category text)");}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if exists orders");
        db.execSQL("DROP TABLE if exists favorites");
        onCreate(db);
    }

    public boolean insertOrder(String name_surname, String address, String phone, int price, int quantity, int image, String book_name, String author_name, int description, String language) {
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name_surname", name_surname);
        values.put("address", address);
        values.put("phone", phone);
        values.put("price", price);
        values.put("quantity", quantity);
        values.put("image", image);
        values.put("book_name", book_name);
        values.put("author_name", author_name);
        values.put("description", description);
        values.put("language", language);
        long n = database.insert("orders", null, values);
        if (n <= 0)
            return false;
        else
            return true;
    }
    public boolean insertFavorite(String name_surname, String phone, int price, int image, String book_name, String author_name, int description, String category) {
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name_surname", name_surname);
        values.put("phone", phone);
        values.put("price", price);
        values.put("image", image);
        values.put("book_name", book_name);
        values.put("author_name", author_name);
        values.put("description", description);
        values.put("category", category);
        long n = database.insert("favorites", null, values);
        if (n <= 0)
            return false;
        else
            return true;
    }
    public int deletedOrders(String id){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete("orders","order_no="+id,null);
    }
    public int deletedFavorites(String id){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete("favorites","id="+id,null);
    }

    public ArrayList<Order_Model> getOrders() {
        ArrayList<Order_Model> orders = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor c = database.rawQuery("Select order_no, price, image, book_name, author_name from orders", null);
        if (c.moveToFirst()) {
            while (c.moveToNext()) {
                Order_Model model = new Order_Model();
                model.setImage_book(c.getInt(2));
                model.setOrder_no(c.getInt(0) + "");
                model.setName_book(c.getString(3));
                model.setName_author(c.getString(4));
                model.setPrice_book(c.getString(1) + "");
                orders.add(model);
            }
        }
        c.close();
        database.close();
        return orders;
    }
    public ArrayList<Favorite_Model> getFavorites() {
        ArrayList<Favorite_Model> favorites = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor c = database.rawQuery("Select price, image, book_name, author_name, category from favorites", null);
        if (c.moveToFirst()) {
            while (c.moveToNext()) {
                Favorite_Model model = new Favorite_Model();
                model.setImage_book(c.getInt(1));
                model.setBook_name(c.getString(2));
                model.setAuthor_name(c.getString(3));
                model.setPrice(c.getString(0) + "");
                model.setCategory(c.getString(4));
                favorites.add(model);
            }
        }
        c.close();
        database.close();
        return favorites;
    }
}