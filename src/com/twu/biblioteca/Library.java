package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private String welcomeMessage = "Welcome to the Bangalore Public Library!";
    private ArrayList<String> mainMenuOptions = new ArrayList<String>();
    private BookList bookList;
    private Boolean checkOutMode = true;

    public Library () {
        addMenuOptions();
        bookList = new BookList();
    }

    public Library (BookList bookList) {
        addMenuOptions();
        this.bookList = bookList;
    }

    private void addMenuOptions () {
        mainMenuOptions.add("List Books");
    }

    public String welcomeCustomer () {
        return welcomeMessage;
    }

    public String displayMainMenuOptions () {
        String menuOptions = "";
        for (String menuOption: mainMenuOptions) {
            menuOptions += menuOption + "\n";
        }
        return menuOptions;
    }

    public void selectMenuOptions (Customer customer) {
        String userChoice = customer.userChoice();
        while (!userChoice.equals("quit")) {
            if (userChoice.equals("list books")) {
                selectReturnOrCheckOut(customer);
                System.out.println(bookList.displayBooks());
                selectBookOptions(customer);
            } else {
                System.out.println("Select a valid option!");
            }
            userChoice = customer.userChoice();
        }
    }

    private void selectBookOptions (Customer customer) {
        String userChoice = customer.userChoice();
        while (!userChoice.equals("quit")) {
            System.out.println(bookList.processBook(userChoice, checkOutMode));
            System.out.println(bookList.displayBooks());
            userChoice = customer.userChoice();
        }
    }

    private void selectReturnOrCheckOut (Customer customer) {
        System.out.println("Select return or checkout");
        String userChoice = customer.userChoice();
        if (userChoice.equals("return")) {
            this.checkOutMode = false;
        } else {
            this.checkOutMode = true;
        }
    }

}
