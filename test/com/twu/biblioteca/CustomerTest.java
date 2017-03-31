package com.twu.biblioteca;

import org.junit.Test;
import sun.plugin.util.UserProfile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    @Test
    public void choiceReturnWhatUserTypes () {
        Customer customer = new Customer();
        String input = "add 5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("add 5", customer.userChoice());
    }

    @Test
    public void getLibraryNumberShowsCustomersLibraryNumber () {
        Customer c = new Customer();
        assertEquals("111-1111", c.getLibraryNumber());
    }

//    @Test
//    public void seeUserInformationReturnsLibraryUserProfile () {
//        UserInfo up = FormatData.buildUserInfo();
//        Customer c = new Customer(up);
//        AllUsers au = new AllUsers(up);
//        Library l = new Library(au);
//        assertEquals("Jack Slater\njs@email.com\nChorlton, Manchester\n07967292730", c.getUserInfo(l));
//    }

}
