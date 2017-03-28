package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by jack on 28/03/17.
 */
public class BookList {
    private ArrayList<Book> books = new ArrayList<Book>();

    public BookList () {
        addBooks();
    }

    private void addBooks () {
        books.add(new Book("Harry Potter", "JK Rowling", 1999));
        books.add(new Book ("Lord of The Rings", "JRR Tolkien", 1960));
        books.add(new Book ("Trainspotting", "Irvine Welsh", 1993));
    }

    public String displayBooks () {
        String bookDetails = String.format("%-22s%-22s%-22s\n","Title","Author","Year");
        for (Book book: books) {
            bookDetails += String.format("%-22s%-22s%-22d\n",book.getTitle(),book.getAuthor(),book.getYear());
        }
        return bookDetails;
    }
}
