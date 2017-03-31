package com.twu.biblioteca;


import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MovieListTest {

    @Test
    public void displayMovieDetailsDisplaysMoviesInColumns () {
        ArrayList<LibraryItem> movies = FormatData.addMoviesToMovieList();
        MovieList ml = new MovieList(movies);
        assertEquals(FormatData.movieListExpectedOutput(), ml.displayLibraryItems());
    }

    MovieList mlGen = new MovieList();

    @Test
    public void formatHeaderReturnsHeaderInCorrectFormat () {
        String res = String.format("%-22s%-22s%-22s%-22s\n","Title","Director","Year","Rating");
        assertEquals(res, mlGen.formatHeader());
    }

    @Test
    public void formatDetailsReturnMovieInCorrectFormat () {
        Movie m = new Movie("Godfather", 1974, "Francis Ford Coppola", 10);
        String res = String.format("%-22s%-22s%-22d%-22s\n","Godfather", "Francis Ford Coppola", 1974,  "10");
        assertEquals(res, mlGen.formatItemDetails(m));
    }

    @Test
    public void showSuccesfulMessageWithFalseShowsReturnMessage () {
        assertEquals("Thank you for returning the movie.", mlGen.showSuccesfulMessages(false));
    }

    @Test
    public void showSuccesfulMessageWithTrueShowsCheckoutMessage () {
        assertEquals("Thank you! Enjoy the movie.", mlGen.showSuccesfulMessages(true));
    }

    @Test
    public void showUnsuccesfulMessageWithFalseShowsReturnMessage () {
        assertEquals("That is not a valid movie to return.", mlGen.showUnsuccesfulMessages(false));
    }

    @Test
    public void showUnuccesfulMessageWithTrueShowsCheckoutMessage () {
        assertEquals("That movie is not available.", mlGen.showUnsuccesfulMessages(true));
    }
}
