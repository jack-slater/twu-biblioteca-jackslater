package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        BookList bl = new BookList();
        System.out.println(bl.displayBooks());
        Library l = new Library(bl);
        Customer c = new Customer();
        System.out.println(l.welcomeCustomer());
        System.out.println(l.displayMainMenuOptions());
        l.selectMenuOptions(c);
    }
}
