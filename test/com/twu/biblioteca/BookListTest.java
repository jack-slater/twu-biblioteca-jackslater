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
        String ln = "111-1111";
        CheckedOutItems coi = new CheckedOutItems();
        ArrayList<LibraryItem> books = FormatData.addBooksToBookList();
        BookList bl = new BookList(books);
        assertEquals(FormatData.bookListExpectedOutput(), bl.displayLibraryItems());
        bl.processLibraryItem("Harry Potter", true, ln, coi);
        assertEquals(FormatData.bookListHarryPotterRemovedOutput(), bl.displayLibraryItems());
    }

    @Test
    public void customerSeesSuccessfulCheckoutMessageWhenCheckingOutBook () {
        String ln = "111-1111";
        CheckedOutItems coi = new CheckedOutItems();
        ArrayList<LibraryItem> books = FormatData.addBooksToBookList();
        BookList bl = new BookList(books);
        assertEquals("Thank you! Enjoy the book.", bl.processLibraryItem("Harry Potter", true, ln, coi));
    }

    @Test
    public void  customerSeesUnsuccesfulCheckoutMessageWhenNoTitleMatch () {
        String ln = "111-1111";
        CheckedOutItems coi = new CheckedOutItems();
        ArrayList<LibraryItem> books = FormatData.addBooksToBookList();
        BookList bl = new BookList(books);
        assertEquals("That book is not available.", bl.processLibraryItem("incorrect title", true, ln, coi));
    }

    @Test
    public void returnedBookShouldAppearOnBookList () {
        String ln = "111-1111";
        CheckedOutItems coi = new CheckedOutItems();
        ArrayList<LibraryItem> books = FormatData.addBooksToBookList();
        BookList bl = new BookList(books);
        assertEquals(FormatData.bookListExpectedOutput(), bl.displayLibraryItems());
        bl.processLibraryItem("Harry Potter", true, ln, coi);
        assertEquals(FormatData.bookListHarryPotterRemovedOutput(), bl.displayLibraryItems());
        bl.processLibraryItem("Harry Potter", false, ln, coi);
        assertEquals(FormatData.bookListExpectedOutput(), bl.displayLibraryItems());
    }

    @Test
    public void customerSeesSuccessfulReturnMessageWhenReturningBook () {
        String ln = "111-1111";
        CheckedOutItems coi = new CheckedOutItems();
        ArrayList<LibraryItem> books = FormatData.addBooksToBookList();
        BookList bl = new BookList(books);
        bl.processLibraryItem("Harry Potter", true, ln, coi);
        assertEquals("Thank you for returning the book.", bl.processLibraryItem("Harry Potter", false, ln, coi));
    }

    @Test
    public void  customerSeesUnsuccesfulReturnMessageWhenNoTitleMatch () {
        String ln = "111-1111";
        CheckedOutItems coi = new CheckedOutItems();
        ArrayList<LibraryItem> books = FormatData.addBooksToBookList();
        BookList bl = new BookList(books);
        assertEquals("That is not a valid book to return.", bl.processLibraryItem("incorrect title", false, ln, coi));
    }

    @Test
    public void customerCannotReturnABookAlreadyCheckedIn () {
        String ln = "111-1111";
        CheckedOutItems coi = new CheckedOutItems();
        ArrayList<LibraryItem> books = FormatData.addBooksToBookList();
        BookList bl = new BookList(books);
        assertEquals("That is not a valid book to return.", bl.processLibraryItem("Harry Potter", false, ln, coi));
    }

}
