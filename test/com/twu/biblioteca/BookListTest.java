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
        bl.selectBookOptions("Harry Potter");
        assertEquals(FormatData.bookListHarryPotterRemovedOutput(), bl.displayBooks());
    }

    @Test
    public void customerSeesSuccessfulCheckoutMessageWhenCheckingOutBook () {
        assertEquals("Thank you! Enjoy the book", new BookList().selectBookOptions("Harry Potter"));
    }

}
