package com.example.bookpurchaseapp.models;

public class Main_Model {

    private int image_book,description;
    private String book_name, author_name, price, category,language;

    public Main_Model(int image_book, String book_name, String author_name, String price, String category, int description, String language) {
        this.image_book = image_book;
        this.book_name = book_name;
        this.author_name = author_name;
        this.price = price;
        this.category = category;
        this.description = description;
        this.language = language;
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

    public void setCategory(String category) {
        this.category = category;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String description) {
        this.language = language;
    }

}
