package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BookListTest {

    @Test
    public void displayBookDetailsDisplaysBooksInColumns () {
        ArrayList<LibraryItem> books = FormatData.addBooksToBookList();
        BookList bl = new BookList(books);
        assertEquals(FormatData.bookListExpectedOutput(), bl.displayLibraryItems());
    }

    @Test
    public void checkedOutBooksShouldNotDisplayOnTheList () {
        ArrayList<LibraryItem> books = FormatData.addBooksToBookList();
        BookList bl = new BookList(books);
        assertEquals(FormatData.bookListExpectedOutput(), bl.displayLibraryItems());
        bl.processLibraryItem("Harry Potter", true);
        assertEquals(FormatData.bookListHarryPotterRemovedOutput(), bl.displayLibraryItems());
    }

    @Test
    public void customerSeesSuccessfulCheckoutMessageWhenCheckingOutBook () {
        ArrayList<LibraryItem> books = FormatData.addBooksToBookList();
        BookList bl = new BookList(books);
        assertEquals("Thank you! Enjoy the book.", bl.processLibraryItem("Harry Potter", true));
    }

    @Test
    public void  customerSeesUnsuccesfulCheckoutMessageWhenNoTitleMatch () {
        ArrayList<LibraryItem> books = FormatData.addBooksToBookList();
        BookList bl = new BookList(books);
        assertEquals("That book is not available.", bl.processLibraryItem("incorrect title", true));
    }

    @Test
    public void returnedBookShouldAppearOnBookList () {
        ArrayList<LibraryItem> books = FormatData.addBooksToBookList();
        BookList bl = new BookList(books);
        assertEquals(FormatData.bookListExpectedOutput(), bl.displayLibraryItems());
        bl.processLibraryItem("Harry Potter", true);
        assertEquals(FormatData.bookListHarryPotterRemovedOutput(), bl.displayLibraryItems());
        bl.processLibraryItem("Harry Potter", false);
        assertEquals(FormatData.bookListExpectedOutput(), bl.displayLibraryItems());
    }

    @Test
    public void customerSeesSuccessfulReturnMessageWhenReturningBook () {
        ArrayList<LibraryItem> books = FormatData.addBooksToBookList();
        BookList bl = new BookList(books);
        bl.processLibraryItem("Harry Potter", true);
        assertEquals("Thank you for returning the book.", bl.processLibraryItem("Harry Potter", false));
    }

    @Test
    public void  customerSeesUnsuccesfulReturnMessageWhenNoTitleMatch () {
        ArrayList<LibraryItem> books = FormatData.addBooksToBookList();
        BookList bl = new BookList(books);
        assertEquals("That is not a valid book to return.", bl.processLibraryItem("incorrect title", false));
    }

    @Test
    public void customerCannotReturnABookAlreadyCheckedIn () {
        ArrayList<LibraryItem> books = FormatData.addBooksToBookList();
        BookList bl = new BookList(books);
        assertEquals("That is not a valid book to return.", bl.processLibraryItem("Harry Potter", false));
    }

}
