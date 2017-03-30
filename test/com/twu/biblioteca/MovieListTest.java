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
}
