package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
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
        inContent("List Books");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        l.selectMenuOptions(c);
        assertEquals(formatBookListExpectedOutput(), outContent.toString());
    }

    @Test
    public void selectMenuOptionsUserSelectsBookListIsNotCaseSensitive () {
        inContent("LIST BOOKS");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        l.selectMenuOptions(c);
        assertEquals(formatBookListExpectedOutput(), outContent.toString());
    }

    @Test
    public void selectMenuOptionsUserSelectsInvalidOption () {
        inContent("invalid choice");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        l.selectMenuOptions(c);
        assertEquals("Select a valid option!\n", outContent.toString());

    }

//    @Test
//    public void selectMenuOptionsUserSelectstoQuit () {
//        inContent("quit");
//        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        l.selectMenuOptions(c);
//        assertEquals("Thank you for visiting", outContent.toString());
//    }

    private String formatBookListExpectedOutput () {
        String expectedOutput = String.format("%-22s%-22s%-22s\n","Title","Author","Year");
        expectedOutput += String.format("%-22s%-22s%-22d\n", "Harry Potter", "JK Rowling", 1999);
        expectedOutput += String.format("%-22s%-22s%-22d\n", "Lord of The Rings", "JRR Tolkien", 1960);
        expectedOutput += String.format("%-22s%-22s%-22d\n", "Trainspotting", "Irvine Welsh", 1993);
        return expectedOutput + "\n";
    }

    private void inContent (String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
