package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LibraryItemTest {
    LibraryItem hp = new LibraryItem("Library Item", 1999);
    @Test
    public void getTitleShowBooksTitle () {
        assertEquals("Library Item", hp.getTitle());
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
