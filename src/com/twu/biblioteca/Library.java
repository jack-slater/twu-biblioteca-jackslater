package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private String welcomeMessage = "Welcome to the Bangalore Public Library!";
    private ArrayList<String> mainMenuOptions = new ArrayList<String>();
    private BookList bookList;

    public Library () {
        addMenuOptions();
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

    public String selectMenuOptions (Customer customer) {
        String userChoice = customer.userChoice();
        if (userChoice.equals("list books")) {
            return bookList.displayBooks();
        } else {
            return "Select a valid option!";
        }
    }
}
