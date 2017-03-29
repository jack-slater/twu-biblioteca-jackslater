package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private String welcomeMessage = "Welcome to the Bangalore Public Library!";
    private ArrayList<String> mainMenuOptions = new ArrayList<String>();
    private BookList bookList;

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
                System.out.println(bookList.displayBooks());
                userChoice = customer.userChoice();
                bookList.selectBookOptions(userChoice);
            } else {
                System.out.println("Select a valid option!");
            }
            userChoice = customer.userChoice();
        }
    }

}
