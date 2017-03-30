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
        FormatData.inContent("List Books");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        l.selectMenuOptions(c);
        assertEquals(FormatData.bookListExpectedOutput() + "\n", outContent.toString());
    }

    @Test
    public void selectMenuOptionsUserSelectsBookListIsNotCaseSensitive () {
        FormatData.inContent("LIST BOOKS");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        l.selectMenuOptions(c);
        assertEquals(FormatData.bookListExpectedOutput() + "\n", outContent.toString());
    }

    @Test
    public void selectMenuOptionsUserSelectsInvalidOption () {
        FormatData.inContent("invalid choice");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        l.selectMenuOptions(c);
        assertEquals("Select a valid option!\n", outContent.toString());
    }

    @Test
    public void userCanChooseToReturnOrCheckOutABook () {

    }

//    @Test
//    public void selectMenuOptionsUserSelectstoQuit () {
//        inContent("quit");
//        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        l.selectMenuOptions(c);
//        assertEquals("Thank you for visiting", outContent.toString());
//    }

}
