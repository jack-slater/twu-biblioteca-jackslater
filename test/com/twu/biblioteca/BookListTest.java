package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

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
        bl.selectBook ("Harry Potter");
        assertEquals(FormatData.bookListHarryPotterRemovedOutput(), bl.displayBooks());
    }

    @Test
    public void customerSeesSuccessfulCheckoutMessageWhenCheckingOutBook () {
        assertEquals("Thank you! Enjoy the book", new BookList().selectBook("Harry Potter"));
    }

    @Test
    public void  customerSeesUnsuccesfulCheckoutMessageWhenNoTitleMatch () {
        BookList bl = new BookList();
        assertEquals("That book is not available.", bl.selectBook("incorrect title"));
    }

}
