package com.example.bookpurchaseapp.models;

public class Favorite_Model  {

    private int image_book;
    private String book_name, author_name, price, category,id;

    public Favorite_Model() {
        this.image_book = image_book;
        this.book_name = book_name;
        this.author_name = author_name;
        this.price = price;
        this.category = category;
        this.id = id;
    }
    public int getImage_book() {
        return image_book;
    }

    public void setImage_book(int image_book) {
        this.image_book = image_book;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) { this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}