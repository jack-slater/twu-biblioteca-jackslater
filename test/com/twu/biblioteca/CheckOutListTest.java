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

    @Test
    public void findCheckoutProductSendsNotFoundWhenNotThere () {
        Book b = new Book("Harry Potter", "JK Rowling", 1999);
        CheckedOutItems col = new CheckedOutItems("111-1111", b);
        assertEquals("Item not found", col.findItemByName("incorrect"));
    }


    @Test
    public void addItemPutsItemAndLibraryNumberOnList () {
        Book b = new Book("Harry Potter", "JK Rowling", 1999);
        CheckedOutItems coi = new CheckedOutItems();
        assertEquals("Item not found", coi.findItemByName("Harry Potter"));
        coi.addItem("111-1111", b);
        assertEquals("111-1111", coi.findItemByName("Harry Potter"));
    }

    @Test
    public void removeItemRemovesItemFromList () {
        Book b = new Book("Harry Potter", "JK Rowling", 1999);
        CheckedOutItems coi = new CheckedOutItems("111-1111", b);
        assertEquals("111-1111", coi.findItemByName("Harry Potter"));
        coi.removeItem("Harry Potter");
        assertEquals("Item not found", coi.findItemByName("Harry Potter"));
    }

}
