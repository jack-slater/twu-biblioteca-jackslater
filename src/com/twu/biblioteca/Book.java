package com.twu.biblioteca;

/**
 * Created by jack on 28/03/17.
 */
public class Book {
    private String title;
    private String author;
    private int year;
    private Boolean inLibrary;

    public Book (String title, String author, Integer year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.inLibrary = true;
    }

    public String getTitle () {
        return title;
    }

    public String getAuthor () {
        return author;
    }

    public int getYear () {
        return year;
    }

    public Boolean checkInLibrary () {
        return this.inLibrary;
    }

    public void changeInLibraryStatus () {
        this.inLibrary = !this.inLibrary;
    }
}
