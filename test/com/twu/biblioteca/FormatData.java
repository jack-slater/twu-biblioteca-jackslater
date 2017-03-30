package com.twu.biblioteca;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Created by jack on 29/03/17.
 */
public class FormatData {

    public static String bookListExpectedOutput () {
       String expectedOutput = String.format("%-22s%-22s%-22s\n","Title","Author","Year");
       expectedOutput += String.format("%-22s%-22s%-22d\n", "Harry Potter", "JK Rowling", 1999);
       expectedOutput += String.format("%-22s%-22s%-22d\n", "Lord of The Rings", "JRR Tolkien", 1960);
       expectedOutput += String.format("%-22s%-22s%-22d\n", "Trainspotting", "Irvine Welsh", 1993);
       return expectedOutput;
    }

    public static String bookListHarryPotterRemovedOutput () {
        String expectedOutput = String.format("%-22s%-22s%-22s\n","Title","Author","Year");
        expectedOutput += String.format("%-22s%-22s%-22d\n", "Lord of The Rings", "JRR Tolkien", 1960);
        expectedOutput += String.format("%-22s%-22s%-22d\n", "Trainspotting", "Irvine Welsh", 1993);
        return expectedOutput;
    }


    public static void inContent (String input) {
          InputStream in = new ByteArrayInputStream(input.getBytes());
          System.setIn(in);
     }
}
