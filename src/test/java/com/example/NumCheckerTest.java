package com.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class NumCheckerTest {

    @Test
    public void testNullString() {
        String s = null;
        assertFalse(NumChecker.isNumeric(s));
    }

    @Test
    public void testEmptyString() {
        String s = "";
        assertFalse(NumChecker.isNumeric(s));
    }

    @Test
    public void testValidString() {
        String s = "123456";
        assertTrue(NumChecker.isNumeric(s));
    }

}
