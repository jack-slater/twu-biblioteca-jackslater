package com.twu.biblioteca;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Customer {

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
