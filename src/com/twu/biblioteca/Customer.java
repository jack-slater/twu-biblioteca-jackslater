package com.twu.biblioteca;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Customer {
    private String libraryNumber;

    public Customer () {
        this.libraryNumber = "111-1111";
    }

    public Customer (UserInfo userInfo) {
        this.libraryNumber = userInfo.getLibraryNumber();
    }

    public String getLibraryNumber () {
        return this.libraryNumber;
    }

//    public String getUserInfo() {
//
//    }

    public String userChoice () {
        Scanner scanner = new Scanner(System.in);
        try{
            return scanner.nextLine().toLowerCase();
        }
        catch (NoSuchElementException e) {
            return "quit";
        }
    }
}
