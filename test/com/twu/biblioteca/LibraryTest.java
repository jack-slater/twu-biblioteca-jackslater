package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    BookList bl = new BookList();
    Library l = new Library(bl);
    Customer c = new Customer();

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
        String input = "List Books";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(formatBookListExpectedOutput(), l.selectMenuOptions(c));
    }

    @Test
    public void selectMenuOptionsUserSelectsInvalidOption () {
        String input = "invalid choice";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("Select a valid option!", l.selectMenuOptions(c));
    }

    private String formatBookListExpectedOutput () {
        String expectedOutput = String.format("%-22s%-22s%-22s\n","Title","Author","Year");
        expectedOutput += String.format("%-22s%-22s%-22d\n", "Harry Potter", "JK Rowling", 1999);
        expectedOutput += String.format("%-22s%-22s%-22d\n", "Lord of The Rings", "JRR Tolkien", 1960);
        expectedOutput += String.format("%-22s%-22s%-22d\n", "Trainspotting", "Irvine Welsh", 1993);
        return expectedOutput;
    }

}
