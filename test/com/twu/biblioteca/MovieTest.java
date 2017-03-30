package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MovieTest {
    Movie m = new Movie("Godfather", 1974, "Francis Ford Coppola", 10);
    @Test
    public void getDirectorShowsDirectorOfFile () {
        assertEquals("Francis Ford Coppola", m.getDirector());
    }

    @Test
    public void getRatingWhenRatingIsBetween1to10 () {
        Movie m = new Movie("title", 1999, "director", 6);
        assertEquals("6", m.getRating());
    }

    @Test
    public void getRatingWhenRatingIsMoreThan10 () {
        Movie m = new Movie("title", 1999, "director", 34);
        assertEquals("unrated", m.getRating());
    }

    @Test
    public void getRatingWhenRatingIsLessThan10 () {
        Movie m = new Movie("title", 1999, "director", 0);
        assertEquals("unrated", m.getRating());
    }
}
