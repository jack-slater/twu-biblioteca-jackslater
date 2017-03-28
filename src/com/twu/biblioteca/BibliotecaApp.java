package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library bangalore = new Library();
        BookList bl = new BookList();
        System.out.println(bangalore.welcomeCustomer());
        System.out.println(bangalore.displayMainMenuOptions());
        System.out.println(bl.displayBooks());
    }
}
