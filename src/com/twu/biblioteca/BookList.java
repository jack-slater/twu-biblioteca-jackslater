package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by jack on 28/03/17.
 */
public class BookList {
    private ArrayList<String> books = new ArrayList<String>();

    public BookList () {
        addBooks();
    }

    private void addBooks () {
        books.add("Harry Potter");
        books.add("Lord of The Rings");
        books.add("Trainspotting");
    }

    public String displayBooks () {
        String bookList = "";
        for (String book: books) {
            bookList += book + "\n";
        }
        return bookList;
    }
}
