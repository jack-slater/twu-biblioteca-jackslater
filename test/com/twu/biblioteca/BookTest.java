package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BookTest {
    Book hp = new Book("Harry Potter", "JK Rowling", 1999);
    @Test
    public void getTitleShowBooksTitle () {
        assertEquals("Harry Potter", hp.getTitle());
    }

    @Test
    public void getAuthorShowBooksAuthor () {
        assertEquals("JK Rowling", hp.getAuthor());
    }

    @Test
    public void getYearShowBooksYear () {
        assertEquals(1999, hp.getYear());
    }
}
