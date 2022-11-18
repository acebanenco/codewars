package com.acebanenco.codewars;

import java.util.Arrays;

public class CarMileage {

    public static int isInteresting(int number, int[] awesomePhrases) {
        CarMileage carMileage = new CarMileage();
        return carMileage.isInterestingImpl(number, awesomePhrases);
    }

    int isInterestingImpl(int number, int[] awesomePhrases) {
        if ( testInteresting(number, awesomePhrases) ) {
            return 2;
        }
        for (int mile = 1; mile <= 2; mile++) {
            if (testInteresting(number + mile, awesomePhrases) ) {
                return 1;
            }
        }
        return 0;
    }

    boolean testInteresting(int number, int[] awesomePhrases) {
        if ( isAwesome(number, awesomePhrases) ) {
            return true;
        }
        String input = "" + number;
        if ( input.length() < 3 ) {
            return false;
        }
        if ( isDigitFollowedByZero(input) ) {
            return true;
        }
        if ( isEveryDigitSame(input) ) {
            return true;
        }
        if ( isSequentialIncrementing(input) ) {
            return true;
        }
        if ( isSequentialDecrementing(input) ) {
            return true;
        }
        return isPalindrome(input);
    }

    boolean isAwesome(int number, int[] awesomePhrases) {
        return Arrays.stream(awesomePhrases)
                .anyMatch(n -> n == number);
    }

    boolean isDigitFollowedByZero(String input) {
        return input.matches("^[1-9]0+$");
    }

    boolean isEveryDigitSame(String input) {
        return input.matches("^([1-9])\\1+$");
    }

    boolean isSequentialDecrementing(String input) {
        return "9876543210".contains(input);
    }

    boolean isSequentialIncrementing(String input) {
        return "1234567890".contains(input);
    }

    boolean isPalindrome(String input) {
        return new StringBuilder(input)
                .reverse()
                .toString()
                .equals(input);
    }

}
