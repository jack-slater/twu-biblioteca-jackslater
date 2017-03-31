package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private String welcomeMessage = "Welcome to the Bangalore Public Library!";
    private MainMenu mainMenu;
    private BookList bookList;
    private MovieList movieList;
    private Boolean checkOutMode = true;
    private AllUsers allUsers;

    public Library () {
        this.mainMenu = new MainMenu();
        this.bookList = new BookList();
        this.movieList = new MovieList();
        this.allUsers = new AllUsers();
    }

    public Library (ArrayList<LibraryItem> bookList, ArrayList<LibraryItem> movieList) {
        this.mainMenu = new MainMenu();
        this.bookList = new BookList(bookList);
        this.movieList = new MovieList(movieList);
    }

    public Library (AllUsers allUsers) {
        this.allUsers = allUsers;
    }

    public String welcomeCustomer () {
        return welcomeMessage;
    }

    public void selectMenuOptions (Customer customer) {
        System.out.println(mainMenu.displayMainMenu());
        String userChoice = customer.userChoice();
        while (!userChoice.equals("quit")) {
            if (userChoice.equals("list books")) selectItemOptions(customer, this.bookList);
            if (userChoice.equals("list movies")) selectItemOptions(customer, this.movieList);
            else System.out.println(mainMenu.processInvalidChoice(userChoice));

            System.out.println(mainMenu.displayMainMenu());
            userChoice = customer.userChoice();
        }
    }

    public Boolean checkUserLogin (Customer customer) {
        String libraryNumber = customer.getLibraryNumber();
        UserInfo userInfo = allUsers.findUserByLibraryNumber(libraryNumber);
        return userInfo == null ? false: userInfo.getCustomerLoggedIn();
    }

    private void selectItemOptions(Customer customer, LibraryItemList itemList) {
        System.out.println("Select return or checkout");
        String userChoice = customer.userChoice();
        selectReturnOrCheckOut(userChoice);
        while (!userChoice.equals("quit")) {
            System.out.println("Select return or checkout at anytime to change mode or quit to exit");
            if (userChoice.equals("return") || userChoice.equals("checkout")) {
                selectReturnOrCheckOut(userChoice);
            } else {
                System.out.println(itemList.processLibraryItem(userChoice, checkOutMode));
            }
            System.out.println(itemList.displayLibraryItems());
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
