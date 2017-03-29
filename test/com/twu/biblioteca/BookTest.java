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

    @Test
    public void checkInLibraryShowsinLibraryBoolean () {
        assertEquals(true, hp.checkInLibrary());
    }

    @Test
    public void changeInLibraryStatusChangeCorrectly () {
        assertEquals(true, hp.checkInLibrary());
        hp.changeInLibraryStatus();
        assertEquals(false, hp.checkInLibrary());
        hp.changeInLibraryStatus();
        assertEquals(true, hp.checkInLibrary());
    }

}
