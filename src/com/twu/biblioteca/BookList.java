package com.twu.biblioteca;

import java.util.ArrayList;

public class BookList extends LibraryItemList {

    public BookList () {
        super();
    }

    public BookList (ArrayList<LibraryItem> itemsList) {
        super(itemsList);
    }

    @Override
    public String formatHeader() {
        return String.format("%-22s%-22s%-22s\n","Title","Author","Year");
    }

    @Override
    public String formatItemDetails(LibraryItem item) {
        Book book = (Book) item;
        return String.format("%-22s%-22s%-22d\n",book.getTitle(),book.getAuthor(),book.getYear());
    }

    @Override
    public String showSuccesfulMessages(Boolean checkOutMode) {
        return checkOutMode ? "Thank you! Enjoy the book." :
                "Thank you for returning the book.";
    }

    @Override
    public String showUnsuccesfulMessages(Boolean checkOutMode) {
        return checkOutMode ? "That book is not available." :
                "That is not a valid book to return.";
    }
}
