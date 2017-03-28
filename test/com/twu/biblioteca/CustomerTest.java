package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    @Test
    public void choiceReturnWhatUserTypes () {
        Customer customer = new Customer();
        String input = "add 5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("add 5", customer.userChoice());
    }

}
