package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CheckOutListTest {
    @Test
    public void findCheckoutProductByItemNameAndGetLibraryNumberWhoHasIt () {
        Book b = new Book("Harry Potter", "JK Rowling", 1999);
        CheckedOutItems col = new CheckedOutItems("111-1111", b);
        assertEquals("111-1111", col.findItemByName("Harry Potter"));
    }
}
