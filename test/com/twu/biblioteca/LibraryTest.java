package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    @Test
    public void welcomeCustomerDisplaysWelcomeMessage () {
        assertEquals(new Library().welcomeCustomer(), "Welcome to the Bangalore Public Library!");
    }

    @Test
    public void displayMainMenuShowsMenuOption_ListBooks () throws Exception {
        assertEquals("List Books\n", new Library().displayMainMenuOptions());
    }

    @Test
    public void selectMenuOptionsUserSelectsBookList () {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book ("Harry Potter", "JK Rowling", 1999));
        BookList bl = new BookList(books);
        Library l = new Library(bl);
        Customer c = new Customer();
        assertEquals(formatExpectedOutput(), l.selectMenuOptions(c));
    }

    private String formatExpectedOutput () {
        String expectedOutput = String.format("%-22s%-22s%-22s\n","Title","Author","Year");
        expectedOutput += String.format("%-22s%-22s%-22d\n", "Harry Potter", "JK Rowling", 1999);
        return expectedOutput;
    }

}
