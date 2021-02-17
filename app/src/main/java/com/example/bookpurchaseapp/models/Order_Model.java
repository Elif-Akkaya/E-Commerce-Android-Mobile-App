package com.example.bookpurchaseapp.models;

public class Order_Model {

    private int image_book;
    private String name_book, name_author, order_no, price_book;

    public Order_Model(){
        this.image_book = image_book;
        this.name_book = name_book;
        this.name_author = name_author;
        this.order_no = order_no;
        this.price_book = price_book;
    }

    public int getImage_book() {
        return image_book;
    }

    public void setImage_book(int image_book) {
        this.image_book = image_book;
    }

    public String getName_book() {
        return name_book;
    }

    public void setName_book(String name_book) {
        this.name_book = name_book;
    }

    public String getName_author() {
        return name_author;
    }

    public void setName_author(String name_author) {
        this.name_author = name_author;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getPrice_book() {
        return price_book;
    }

    public void setPrice_book(String price_book) {
        this.price_book = price_book;
    }
}

