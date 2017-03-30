package com.twu.biblioteca;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by jack on 29/03/17.
 */
public class FormatData {

    public static ArrayList<LibraryItem> addBooksToBookList () {
        ArrayList<LibraryItem> books = new ArrayList<LibraryItem>();
        books.add(new Book("Harry Potter", "JK Rowling", 1999));
        books.add(new Book("Lord of The Rings", "JRR Tolkien", 1960));
        books.add(new Book("Trainspotting", "Irvine Welsh", 1993));
        return books;
    }

    public static ArrayList<LibraryItem> addMoviesToMovieList () {
        ArrayList<LibraryItem> movies = new ArrayList<LibraryItem>();
        movies.add(new Movie("Godfather", 1974, "Francis Ford Coppola", 10));
        movies.add(new Movie("Captain America", 2008, "Russo Brothers", 6));
        movies.add(new Movie("Good Will Hunting", 1998, "Matt Damon", 7));
        return movies;
    }

    public static String movieListExpectedOutput () {
        String expectedOutput = String.format("%-22s%-22s%-22s%-22s\n","Title","Director","Year","Rating");
        expectedOutput += String.format("%-22s%-22s%-22d%-22s\n", "Godfather", "Francis Ford Coppola", 1974, 10);
        expectedOutput += String.format("%-22s%-22s%-22d%-22s\n", "Captain America","Russo Brothers", 2008,  6);
        expectedOutput += String.format("%-22s%-22s%-22d%-22s\n", "Good Will Hunting", "Matt Damon", 1998, 7);
        return expectedOutput;
    }

    public static String bookListExpectedOutput () {
       String expectedOutput = String.format("%-22s%-22s%-22s\n","Title","Author","Year");
       expectedOutput += String.format("%-22s%-22s%-22d\n", "Harry Potter", "JK Rowling", 1999);
       expectedOutput += String.format("%-22s%-22s%-22d\n", "Lord of The Rings", "JRR Tolkien", 1960);
       expectedOutput += String.format("%-22s%-22s%-22d\n", "Trainspotting", "Irvine Welsh", 1993);
       return expectedOutput;
    }

    public static String bookListHarryPotterRemovedOutput () {
        String expectedOutput = String.format("%-22s%-22s%-22s\n","Title","Author","Year");
        expectedOutput += String.format("%-22s%-22s%-22d\n", "Lord of The Rings", "JRR Tolkien", 1960);
        expectedOutput += String.format("%-22s%-22s%-22d\n", "Trainspotting", "Irvine Welsh", 1993);
        return expectedOutput;
    }


    public static void inContent (String input) {
          InputStream in = new ByteArrayInputStream(input.getBytes());
          System.setIn(in);
     }
}
