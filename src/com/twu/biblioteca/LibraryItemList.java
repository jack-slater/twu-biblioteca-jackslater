package com.twu.biblioteca;


import java.util.ArrayList;

public abstract class LibraryItemList {
    private ArrayList<LibraryItem> itemsList;

    public LibraryItemList () {
        this.itemsList = new ArrayList<LibraryItem>();
    }

    public LibraryItemList (ArrayList<LibraryItem> itemsList) {
        this.itemsList = itemsList;
    }

    public String displayLibraryItems() {
        String itemDetails = formatHeader();
        for (LibraryItem item: itemsList) {
            if (item.checkInLibrary()) {
                itemDetails += formatItemDetails(item);
            }
        }
        return itemDetails;
    }

    public void addItems (LibraryItem item) {
        this.itemsList.add(item);
    };

    public abstract String formatHeader ();

    public abstract String formatItemDetails (LibraryItem item);

    public String processLibraryItem(String userChoice, Boolean checkOutMode, String libraryNumber, CheckedOutItems checkedOutItems) {
        for (LibraryItem item: itemsList) {
            if (item.getTitle().toLowerCase().equals(userChoice.toLowerCase())) {
                if (!checkOutMode.equals(item.checkInLibrary())) break;
                item.changeInLibraryStatus(libraryNumber, checkedOutItems);
                return showSuccesfulMessages(checkOutMode);
            }
        }
        return showUnsuccesfulMessages(checkOutMode);
    }

    public abstract String showSuccesfulMessages (Boolean checkOutMode);
    public abstract String showUnsuccesfulMessages (Boolean checkOutMode);
}
