package com.twu.biblioteca;


public class Book extends LibraryItem {
    private String author;

    public Book (String title, String author, Integer year) {
        super(title, year);
        this.author = author;
    }

    public String getAuthor () {
        return author;
    }

}
