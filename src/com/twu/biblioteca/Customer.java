package com.twu.biblioteca;

import java.util.Scanner;

/**
 * Created by jack on 28/03/17.
 */
public class Customer {

    public String userChoice () {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toLowerCase();
    }
}
