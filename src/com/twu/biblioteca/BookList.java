package com.twu.biblioteca;

import java.util.ArrayList;

public class BookList {
    private ArrayList<Book> books = new ArrayList<Book>();

    public BookList () {
        addBooks();
    }

    public BookList (ArrayList<Book> books) {
        this.books = books;
    }

    private void addBooks () {
        books.add(new Book("Harry Potter", "JK Rowling", 1999));
        books.add(new Book ("Lord of The Rings", "JRR Tolkien", 1960));
        books.add(new Book ("Trainspotting", "Irvine Welsh", 1993));
    }

    public String displayBooks () {
        String bookDetails = String.format("%-22s%-22s%-22s\n","Title","Author","Year");
        for (Book book: books) {
            if (book.checkInLibrary()) {
                bookDetails += String.format("%-22s%-22s%-22d\n",book.getTitle(),book.getAuthor(),book.getYear());
            }
        }
        return bookDetails;
    }

    public String processBook(String userChoice, Boolean checkOutMode) {
        for (Book book: books) {
            if (book.getTitle().toLowerCase().equals(userChoice.toLowerCase())) {
                if (!checkOutMode.equals(book.checkInLibrary())) break;
                book.changeInLibraryStatus();
                return checkOutMode ? "Thank you! Enjoy the book" :
                        "Thank you for returning the book.";
            }
        }
        return checkOutMode ? "That book is not available." :
              "That is not a valid book to return.";
    }
}
