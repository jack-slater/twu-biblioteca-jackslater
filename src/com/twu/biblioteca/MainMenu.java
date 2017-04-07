package com.twu.biblioteca;

import java.util.ArrayList;

public class MainMenu {
    private ArrayList<String> mainMenuOptions = new ArrayList<String>();

    public MainMenu () {
        mainMenuOptions.add("List Books");
        mainMenuOptions.add("List Movies");
        mainMenuOptions.add("User");
    }

    public String displayMainMenu (Boolean userLoggedIn) {
        String menuOptions = "Main Menu\n";
        for (String menuOption: mainMenuOptions) {
            if (menuOption.equals("User")) menuOption = userLoggedIn ? "User Details" : "Login";
            menuOptions += menuOption + "   ";
        }
        return menuOptions + "\n\nSelect menu option or quit to exit";
    }

    public String processInvalidChoice (String userChoice) {
        return "Select a valid option!";
    }

}
