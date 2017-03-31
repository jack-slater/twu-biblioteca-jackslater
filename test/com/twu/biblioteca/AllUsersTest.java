package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jack on 31/03/17.
 */
public class AllUsersTest {

    @Test
    public void findUserByLibraryNumberBringsCorrectUserInfo () {
        UserInfo ui = FormatData.buildUserInfo();
        String libraryNumber = ui.getLibraryNumber();
        AllUsers au = new AllUsers(ui);
        assertEquals(ui, au.findUserByLibraryNumber(libraryNumber));
    }

    @Test
    public void findUserByLibraryNumberIncorrectLibraryNumber () {
        UserInfo ui = FormatData.buildUserInfo();
        String libraryNumber = "111-2222";
        AllUsers au = new AllUsers(ui);
        assertEquals(null, au.findUserByLibraryNumber(libraryNumber));
    }

    @Test
    public void getNumberOfUsersReturnsSizeOfHashMap () {
        UserInfo ui = FormatData.buildUserInfo();
        AllUsers au = new AllUsers(ui);
        assertEquals(1, au.getNumberOfUsers());
    }

    @Test
    public void addUserIncreasesSizeOfHashMapByOne () {
        UserInfo ui = FormatData.buildUserInfo();
        AllUsers au = new AllUsers();
        assertEquals(0, au.getNumberOfUsers());
        au.addUser(ui);
        assertEquals(1, au.getNumberOfUsers());
    }
}
