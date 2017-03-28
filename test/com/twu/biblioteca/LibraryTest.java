package com.twu.biblioteca;

import org.junit.Test;
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

}
