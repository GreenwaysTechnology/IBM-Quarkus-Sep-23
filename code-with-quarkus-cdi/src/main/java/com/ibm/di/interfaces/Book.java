package com.ibm.di.interfaces;

public class Book {
    private String IsbnNumber;
    private String name;
    private String author;

    public String getIsbnNumber() {
        return IsbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        IsbnNumber = isbnNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(String isbnNumber, String name, String author) {
        IsbnNumber = isbnNumber;
        this.name = name;
        this.author = author;
    }

    public Book() {
    }
}
