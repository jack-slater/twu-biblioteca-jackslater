package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BookListTest {
    @Test
    public void displayBookDetailsDisplaysBooksInColumns () {
        assertEquals(formatExpectedOutput(), new BookList().displayBooks());
    }

    private String formatExpectedOutput () {
        String expectedOutput = String.format("%-22s%-22s%-22s\n","Title","Author","Year");
        expectedOutput += String.format("%-22s%-22s%-22d\n", "Harry Potter", "JK Rowling", 1999);
        expectedOutput += String.format("%-22s%-22s%-22d\n", "Lord of The Rings", "JRR Tolkien", 1960);
        expectedOutput += String.format("%-22s%-22s%-22d\n", "Trainspotting", "Irvine Welsh", 1993);
        return expectedOutput;
    }
}
