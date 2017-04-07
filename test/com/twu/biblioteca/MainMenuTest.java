package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MainMenuTest {
    @Test
    public void selectMenuOptionsUserSelectsInvalidOption () {
        assertEquals("Select a valid option!", new MainMenu().processInvalidChoice("invalid"));
    }

    @Test
    public void displayMenuOptionsShowsMenuOptionsWithLoginWhenUserNotLoggedIn () {
        MainMenu mm = new MainMenu();
        String res = "Main Menu\nList Books   List Movies   Login   \n\nSelect menu option or quit to exit";
        assertEquals(res, mm.displayMainMenu(false));
    }

    @Test
    public void displayMenuOptionsShowsMenuOptionsWithUserProfileWhenUserLoggedIn () {
        MainMenu mm = new MainMenu();
        String res = "Main Menu\nList Books   List Movies   User Details   \n\nSelect menu option or quit to exit";
        assertEquals(res, mm.displayMainMenu(true));
    }
}
