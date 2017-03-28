package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by jack on 28/03/17.
 */
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
        return bookList.displayBooks();
    }
}
