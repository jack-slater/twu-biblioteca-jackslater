package com.twu.biblioteca;

/**
 * Created by jack on 30/03/17.
 */
public class Movie extends LibraryItem {
    private String director;
    private String rating;

    public Movie (String title, Integer year, String director, Integer rating) {
        super(title, year);
        this.director = director;
        this.rating = validateRating(rating);
    }

    public String getDirector () {
        return this.director;
    }

    public String getRating () {
        return this.rating;
    }

    private String validateRating (Integer rating) {
        if (rating > 10 || rating < 1) {
            return "unrated";
        } return rating.toString();
    }
}
