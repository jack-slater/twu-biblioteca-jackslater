package com.twu.biblioteca;

import com.twu.biblioteca.AllUsersList;
import com.twu.biblioteca.FormatData;
import com.twu.biblioteca.UserInfo;
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
        AllUsersList au = new AllUsersList(ui);
        assertEquals(ui, au.findUserByLibraryNumber(libraryNumber));
    }
}
