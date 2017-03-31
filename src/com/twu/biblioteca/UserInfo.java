package com.twu.biblioteca;

/**
 * Created by jack on 31/03/17.
 */
public class UserInfo {
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private String libraryNumber;
    private String password;
    private Boolean customerLoggedIn = false;


    public UserInfo(String name, String email, String address, String phoneNumber, String libraryNumber, String password) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public String getLibraryNumber () {
        return this.libraryNumber;
    }

    public Boolean getCustomerLoggedIn () {
        return customerLoggedIn;
    }

    public void customerLogin (String password) {
        if (password.equals(this.password)) {
            this.customerLoggedIn = true;
        }
    }
}
