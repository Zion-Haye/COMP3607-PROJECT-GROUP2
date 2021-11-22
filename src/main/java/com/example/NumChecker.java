package com.example;


public class NumChecker {// checking to see if the string entered is a number
    public static boolean isNumeric(String string) {

        if (string == null || string.equals("")) {
            return false;
        }

        try {
            int intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
    }

}
