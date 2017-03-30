package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private String welcomeMessage = "Welcome to the Bangalore Public Library!";
    private MainMenu mainMenu;
    private BookList bookList;
    private Boolean checkOutMode = true;

    public Library () {
        this.mainMenu = new MainMenu();
        this.bookList = new BookList();
    }

    public Library (BookList bookList) {
        this.mainMenu = new MainMenu();
        this.bookList = bookList;
    }

    public String welcomeCustomer () {
        return welcomeMessage;
    }

    public void selectMenuOptions (Customer customer) {
        System.out.println(mainMenu.displayMainMenu());
        String userChoice = customer.userChoice();
        while (!userChoice.equals("quit")) {
            if (userChoice.equals("list books")) {
                selectBookOptions(customer);
            } else {
                System.out.println(mainMenu.processInvalidChoice(userChoice));
            }
            System.out.println(mainMenu.displayMainMenu());
            userChoice = customer.userChoice();
        }
    }

    private void selectBookOptions (Customer customer) {
        System.out.println("Select return or checkout");
        String userChoice = customer.userChoice();
        selectReturnOrCheckOut(userChoice);
        while (!userChoice.equals("quit")) {
            System.out.println("Select return or checkout at anytime to change mode or quit to exit");
            if (userChoice.equals("return") || userChoice.equals("checkout")) {
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
        if (userChoice.equals("return")) {
            this.checkOutMode = false;
        } else {
            this.checkOutMode = true;
        }
    }
}
