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
        CheckedOutItems coi = new CheckedOutItems();
        String ln = "111-1111";
        assertEquals(true, hp.checkInLibrary());
        hp.changeInLibraryStatus(ln, coi);
        assertEquals(false, hp.checkInLibrary());
        hp.changeInLibraryStatus(ln, coi);
        assertEquals(true, hp.checkInLibrary());
    }

    @Test
    public void changeInLibraryStatuAddsItemAndUserNumberToCheckOutList () {
        CheckedOutItems coi = new CheckedOutItems();
        assertEquals("Item not found", coi.findItemByName("Library Item"));
        hp.changeInLibraryStatus("111-1111", coi);
        assertEquals("111-1111", coi.findItemByName("Library Item"));
    }

    @Test
    public void changeInLibraryStatuRemovesItemWhenAlreadyThere () {
        CheckedOutItems coi = new CheckedOutItems();
        assertEquals("Item not found", coi.findItemByName("Library Item"));
        hp.changeInLibraryStatus("111-1111", coi);
        assertEquals("111-1111", coi.findItemByName("Library Item"));
        hp.changeInLibraryStatus("111-1111", coi);
        assertEquals("Item not found", coi.findItemByName("Library Item"));
    }
}
