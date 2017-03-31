package com.twu.biblioteca;

import org.junit.Test;

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
        assertEquals(false, l.checkUserLogin(c.getLibraryNumber()));
    }

    @Test
    public void checkUserLoginReturnsTrueWhenLoggedIn () {
        UserInfo ui = FormatData.buildUserInfo();
        ui.changeCustomerLogin("password");
        Customer c = new Customer(ui);
        AllUsers au = new AllUsers(ui);
        Library l = new Library(au);
        assertEquals(true, l.checkUserLogin(c.getLibraryNumber()));
    }

    @Test
    public void sendUserProfileToCustomerSendsProfileWhenLoggedIn () {
        UserInfo ui = FormatData.buildUserInfo();
        ui.changeCustomerLogin("password");
        AllUsers au = new AllUsers(ui);
        Library l = new Library(au);
        assertEquals("Jack Slater\njs@email.com\nChorlton, Manchester\n07967292370", l.getUserProfile("111-1111"));
    }

    @Test
    public void sendUserProfileToCustomerSendsFailMessageWhenNotLoggedIn () {
        AllUsers au = FormatData.addUsersToAllUsers();
        Library l = new Library(au);
        assertEquals("User not logged in", l.getUserProfile("111-1111"));
    }

    @Test
    public void sendUserProfileToCustomerSendsUserNotFoundIfUserNotInAllUsers () {
        AllUsers au = FormatData.addUsersToAllUsers();
        Library l = new Library(au);
        assertEquals("User Profile Not Found", l.getUserProfile("222-2222"));
    }

    @Test
    public void userLoginChangesUserInfoLoggedInToTrue () {
        UserInfo ui = FormatData.buildUserInfo();
        AllUsers au = new AllUsers(ui);
        Library l = new Library(au);
        assertEquals(false, ui.getCustomerLoggedIn());
        l.userLogin("111-1111", "password");
        assertEquals(true, ui.getCustomerLoggedIn());
    }

}
