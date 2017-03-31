package com.twu.biblioteca;

import java.util.HashMap;

/**
 * Created by jack on 31/03/17.
 */
public class AllUsers {
    private HashMap<String, UserInfo> users = new HashMap<String, UserInfo>();

    public AllUsers() {};

    public AllUsers(UserInfo userInfo) {
        users.put(userInfo.getLibraryNumber(), userInfo);
    }

    public void addUser (UserInfo userInfo) {
        users.put(userInfo.getLibraryNumber(), userInfo);
    }

    public int getNumberOfUsers () {
        return users.size();
    }

    public UserInfo findUserByLibraryNumber (String libraryNumber) {
        return users.get(libraryNumber);
    }
}
