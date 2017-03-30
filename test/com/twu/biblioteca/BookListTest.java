package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookListTest {
    @Test
    public void displayBookDetailsDisplaysBooksInColumns () {
        assertEquals(FormatData.bookListExpectedOutput(), new BookList().displayBooks());
    }

    @Test
    public void checkedOutBooksShouldNotDisplayOnTheList () {
        BookList bl = new BookList();
        assertEquals(FormatData.bookListExpectedOutput(), bl.displayBooks());
        bl.processBook("Harry Potter", true);
        assertEquals(FormatData.bookListHarryPotterRemovedOutput(), bl.displayBooks());
    }

    @Test
    public void customerSeesSuccessfulCheckoutMessageWhenCheckingOutBook () {
        assertEquals("Thank you! Enjoy the book", new BookList().processBook("Harry Potter", true));
    }

    @Test
    public void  customerSeesUnsuccesfulCheckoutMessageWhenNoTitleMatch () {
        BookList bl = new BookList();
        assertEquals("That book is not available.", bl.processBook("incorrect title", true));
    }

    @Test
    public void returnedBookShouldAppearOnBookList () {
        BookList bl = new BookList();
        assertEquals(FormatData.bookListExpectedOutput(), bl.displayBooks());
        bl.processBook("Harry Potter", true);
        assertEquals(FormatData.bookListHarryPotterRemovedOutput(), bl.displayBooks());
        bl.processBook ("Harry Potter", false);
        assertEquals(FormatData.bookListExpectedOutput(), bl.displayBooks());
    }

    @Test
    public void customerSeesSuccessfulReturnMessageWhenReturningBook () {
        BookList bl = new BookList();
        bl.processBook("Harry Potter", true);
        assertEquals("Thank you for returning the book.", bl.processBook("Harry Potter", false));
    }

    @Test
    public void  customerSeesUnsuccesfulReturnMessageWhenNoTitleMatch () {
        BookList bl = new BookList();
        assertEquals("That is not a valid book to return.", bl.processBook("incorrect title", false));
    }

    @Test
    public void customerCannotReturnABookAlreadyCheckedIn () {
        BookList bl = new BookList();
        assertEquals("That is not a valid book to return.", bl.processBook("Harry Potter", false));

    }

}
