package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieListTest {
    @Test
    public void displayMovieDetailsDisplaysMoviesInColumns () {
        assertEquals(FormatData.movieListExpectedOutput(), new MovieList().displayBooks());
    }
}
