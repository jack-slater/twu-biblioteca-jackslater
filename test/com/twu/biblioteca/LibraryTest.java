package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    @Test
    public void welcomeCustomerDisplaysWelcomeMessage () {
        assertEquals(new Library().welcomeCustomer(), "Welcome to the Bangalore Public Library!");
    }

    @Test
    public void checkUserLoginReturnsFalseWhenLoggedOut () {
        UserInfo ui = FormatData.buildUserInfo();
        Customer c = new Customer(ui);
        Library l = new Library();
        assertEquals(false, l.checkUserLogin(c));
    }

    @Test
    public void checkUserLoginReturnsTrueWhenLoggedIn () {
        UserInfo ui = FormatData.buildUserInfo();
        ui.customerLogin("password");
        Customer c = new Customer(ui);
        AllUsers au = new AllUsers(ui);
        Library l = new Library(au);
        assertEquals(true, l.checkUserLogin(c));
    }
    


}
