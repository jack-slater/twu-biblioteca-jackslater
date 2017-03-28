package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BookListTest {
    @Test
    public void displayAllBookTitles () {
        assertEquals(new BookList().displayBooks(), "Harry Potter\nLord of The Rings\nTrainspotting\n");
    }
}
