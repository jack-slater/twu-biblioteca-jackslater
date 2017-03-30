package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BookTest {
    Book hp = new Book("Harry Potter", "JK Rowling", 1999);

    @Test
    public void getAuthorShowBooksAuthor () {
        assertEquals("JK Rowling", hp.getAuthor());
    }

}
