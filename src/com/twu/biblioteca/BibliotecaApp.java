package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library l = new Library();
        Customer c = new Customer();
        System.out.println(l.welcomeCustomer());
        System.out.println(l.displayMainMenuOptions());
        l.selectMenuOptions(c);
    }
}
