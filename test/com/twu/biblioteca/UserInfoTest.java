package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * Created by jack on 31/03/17.
 */
public class UserInfoTest {

    @Test
    public void getLibraryNumberReturnsLibraryNumber () {
        UserInfo ui = FormatData.buildUserInfo();
        assertEquals("111-1111", ui.getLibraryNumber());
    }

    @Test
    public void getCustomerLoggedInReturnsFalesBeforeLogin () {
        UserInfo ui = FormatData.buildUserInfo();
        assertEquals(false, ui.getLoggedIn());
    }

    @Test
    public void customerLoginChangesCustomerLoggedInToTrueIfPasswordMatches () {
        UserInfo ui = FormatData.buildUserInfo();
        assertEquals(false, ui.getLoggedIn());
        ui.loginInUser("password");
        assertEquals(true, ui.getLoggedIn());
    }

    @Test
    public void customerLoginDoesntChangeCustomerLoggedIfPasswordMatchesIsWrong () {
        UserInfo ui = FormatData.buildUserInfo();
        assertEquals(false, ui.getLoggedIn());
        ui.loginInUser("wrongPassword");
        assertEquals(false, ui.getLoggedIn());
    }

    @Test
    public void buildUserProfileCardCreatesUserInfoForCustomer () {
        UserInfo ui = FormatData.buildUserInfo();
        assertEquals("Jack Slater\njs@email.com\nChorlton, Manchester\n07967292370", ui.buildUserProfileCard());
    }


}
