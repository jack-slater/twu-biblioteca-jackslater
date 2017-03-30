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
}
