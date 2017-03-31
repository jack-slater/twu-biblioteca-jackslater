package com.twu.biblioteca;

import java.util.HashMap;

/**
 * Created by jack on 31/03/17.
 */
public class AllUsersList {
    private HashMap<String, UserInfo> users = new HashMap<String, UserInfo>();

    public AllUsersList (UserInfo userInfo) {
        users.put(userInfo.getLibraryNumber(), userInfo);
    }

    public UserInfo findUserByLibraryNumber (String libraryNumber) {
        return users.get(libraryNumber);
    }
}
