package com.twu.biblioteca;

public class LibraryItem {
    private String title;
    private int year;
    private Boolean inLibrary;

    public LibraryItem (String title, Integer year) {
        this.title = title;
        this.year = year;
        this.inLibrary = true;
    }

    public String getTitle () {
        return title;
    }

    public int getYear () {
        return year;
    }

    public Boolean checkInLibrary () {
        return this.inLibrary;
    }

    public void changeInLibraryStatus () {
        this.inLibrary = !this.inLibrary;
    }
}
