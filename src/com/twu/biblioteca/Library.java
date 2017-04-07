package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private String welcomeMessage = "Welcome to the Bangalore Public Library!";
    private MainMenu mainMenu;
    private BookList bookList;
    private MovieList movieList;
    private Boolean checkOutMode = true;
    private AllUsers allUsers;
    private CheckedOutItems checkedOutItems;

    public Library () {
        this.mainMenu = new MainMenu();
        this.bookList = new BookList();
        this.movieList = new MovieList();
        this.allUsers = new AllUsers();
        this.checkedOutItems = new CheckedOutItems();
    }

    public Library (BookList bookList, MovieList movieList, AllUsers allUsers) {
        this.allUsers = allUsers;
        this.checkedOutItems = new CheckedOutItems();
        this.mainMenu = new MainMenu();
        this.bookList = bookList;
        this.movieList = movieList;
    }

    public Library (AllUsers allUsers) {
        this.mainMenu = new MainMenu();
        this.bookList = new BookList();
        this.movieList = new MovieList();
        this.allUsers = allUsers;
        this.checkedOutItems = new CheckedOutItems();
    }

    public String welcomeCustomer () {
        return welcomeMessage;
    }

    public void selectMenuOptions (Customer customer) {
        System.out.println(mainMenu.displayMainMenu(false));
        String userChoice = customer.userChoice();
        while (!userChoice.equals("quit")) {
            processMenuChoice(customer, userChoice);
            System.out.println(mainMenu.displayMainMenu(checkUserLogin(customer.getLibraryNumber())));
            userChoice = customer.userChoice();
        }
    }

    private void processMenuChoice(Customer customer, String userChoice) {
        if (userChoice.equals("list books")) selectItemOptions(customer, this.bookList);
        if (userChoice.equals("list movies")) selectItemOptions(customer, this.movieList);
        if (userChoice.equals("login") || userChoice.equals("user details")) {
            processLoginOrUserDetailsChoice(userChoice, customer.getLibraryNumber());
        }
        else System.out.println(mainMenu.processInvalidChoice(userChoice));
    }

    private void processLoginOrUserDetailsChoice (String userChoice, String libraryNumber) {
        Boolean userLoggedIn = checkUserLogin(libraryNumber);
        if (userChoice.equals("login") && !userLoggedIn) userLogin();
        if (userChoice.equals("user details") && userLoggedIn)
            System.out.println(getUserProfile(libraryNumber));
    }

    public Boolean checkUserLogin (String libraryNumber) {
        UserInfo userInfo = allUsers.findUserByLibraryNumber(libraryNumber);
        return userInfo == null ? false: userInfo.getLoggedIn();
    }

    public String getUserProfile(String libraryNumber) {
        UserInfo userInfo = allUsers.findUserByLibraryNumber(libraryNumber);
        if (userInfo == null) return "User Profile Not Found";
        return userInfo.getLoggedIn() ? userInfo.buildUserProfileCard() : "User not logged in";
    }

    private void userLogin () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Library Number");
        String libraryNumber = scanner.nextLine();
        UserInfo userInfo = allUsers.findUserByLibraryNumber(libraryNumber);
        if (userInfo != null) {
            System.out.println("Enter password");
            String password = scanner.nextLine();
            userInfo.loginInUser(password);
            if (checkUserLogin(libraryNumber)) System.out.println("Successful Login");
            else System.out.println("Invalid Password - Type login to retry");
        } else System.out.println("Invalid Library Number - Type login to retry");
    }

    private void selectItemOptions(Customer customer, LibraryItemList itemList) {
        System.out.println("Select return or checkout");
        String userChoice = customer.userChoice();
        selectReturnOrCheckOut(userChoice);
        while (!userChoice.equals("quit")) {
            System.out.println("Select return or checkout at anytime to change mode or quit to exit");
            processItemChoice(customer, itemList, userChoice);
            System.out.println(itemList.displayLibraryItems());
            System.out.println(checkOutMode ? "Checkout Mode" : "Return Mode");
            userChoice = customer.userChoice();
        }
    }

    private void processItemChoice(Customer customer, LibraryItemList itemList, String userChoice) {
        if (userChoice.equals("return") || userChoice.equals("checkout")) {
            selectReturnOrCheckOut(userChoice);
        } else {
            System.out.println(itemList.processLibraryItem(userChoice, checkOutMode,
                    customer.getLibraryNumber(), this.checkedOutItems));
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
