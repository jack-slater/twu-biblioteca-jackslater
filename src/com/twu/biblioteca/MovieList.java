package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by jack on 30/03/17.
 */
public class MovieList extends LibraryItemList {

    public MovieList () {
        super();
    }

    public MovieList (ArrayList<LibraryItem> itemsList) {
        super(itemsList);
    }

    @Override
    public String formatHeader() {
        return String.format("%-22s%-22s%-22s%-22s\n","Title","Director","Year","Rating");
    }

    @Override
    public String formatItemDetails(LibraryItem item) {
        Movie movie = (Movie) item;
        return String.format("%-22s%-22s%-22d%-22s\n",movie.getTitle(),movie.getDirector(),movie.getYear(),movie.getRating());
    }

    @Override
    public String showSuccesfulMessages(Boolean checkOutMode) {
        return checkOutMode ? "Thank you! Enjoy the movie." :
                "Thank you for returning the movie.";
    }

    @Override
    public String showUnsuccesfulMessages(Boolean checkOutMode) {
        return checkOutMode ? "That movie is not available." :
                "That is not a valid movie to return.";
    }
}
