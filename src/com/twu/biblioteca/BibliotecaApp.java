package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library l = setupBangaloreLibrary();
        Customer c = new Customer();
        System.out.println(l.welcomeCustomer());
        l.selectMenuOptions(c);
    }

    public static Library setupBangaloreLibrary () {
        ArrayList<LibraryItem> books = addBooksToBookList();
        BookList bl = new BookList(books);
        ArrayList<LibraryItem> movies = addMoviesToMovieList();
        MovieList ml = new MovieList(movies);
        AllUsers au = buildUserList();
        return new Library(bl, ml, au);
    }

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

    public static AllUsers buildUserList  () {
        UserInfo ui = new UserInfo("Jack Slater", "js@email.com", "Chorlton, Manchester",
                "07967292370", "111-1111", "password");
        return new AllUsers(ui);
    }

}
