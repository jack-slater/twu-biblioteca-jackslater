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

    private String displayMainMenuOptions () {
        String menuOptions = "Main Menu\n";
        for (String menuOption: mainMenuOptions) {
            menuOptions += menuOption + "   ";
        }
        return menuOptions + "\n\nSelect menu option or quit to exit";
    }

    public void selectMenuOptions (Customer customer) {
        System.out.println(displayMainMenuOptions());
        String userChoice = customer.userChoice();
        while (!userChoice.equals("quit")) {
            if (userChoice.equals("list books")) {
                selectBookOptions(customer);
            } else {
                System.out.println("Select a valid option!");
            }
            System.out.println(displayMainMenuOptions());
            userChoice = customer.userChoice();
        }
    }

    private void selectBookOptions (Customer customer) {
        System.out.println("Select return or checkout");
        String userChoice = customer.userChoice();
        selectReturnOrCheckOut(userChoice);
        while (!userChoice.equals("quit")) {
            System.out.println("Select return or checkout at anytime to change mode or quit to exit");
            if (userChoice.equals("return") || userChoice.equals("checkout") || userChoice.equals("quit")) {
                selectReturnOrCheckOut(userChoice);
            } else {
                System.out.println(bookList.processBook(userChoice, checkOutMode));
            }
            System.out.println(bookList.displayBooks());
            System.out.println(checkOutMode ? "Checkout Mode" : "Return Mode");
            userChoice = customer.userChoice();
        }
    }

    private void selectReturnOrCheckOut (String userChoice) {
//        String mode = checkOutMode ? "return" : "checkout";
//        System.out.println("Type " + mode + " to enter " + mode + " mode");
        if (userChoice.equals("return")) {
            this.checkOutMode = false;
        } else {
            this.checkOutMode = true;
        }
    }
}
