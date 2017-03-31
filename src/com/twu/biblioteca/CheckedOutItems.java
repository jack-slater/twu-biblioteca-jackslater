package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by jack on 31/03/17.
 */
public class CheckedOutItems {
    private HashMap<LibraryItem, String> checkedoutItems = new HashMap<LibraryItem, String>();

    public CheckedOutItems () {}

    public CheckedOutItems (String libraryNumber, LibraryItem libraryItem) {
        checkedoutItems.put(libraryItem, libraryNumber);
    }

    public String findItemByName (String itemName) {
        Set<LibraryItem> items = checkedoutItems.keySet();
        for (LibraryItem item: items) {
            if (itemName.equals(item.getTitle())) return checkedoutItems.get(item);
        }
        return "Item not found";
    }

    public void addItem (String libraryNumber, LibraryItem libraryItem) {
        checkedoutItems.put(libraryItem, libraryNumber);
    }

    public void removeItem (String itemName) {
        Set<LibraryItem> items = checkedoutItems.keySet();
        for (LibraryItem item: items) {
            if (itemName.equals(item.getTitle())) checkedoutItems.remove(item);
        }
    }
}
