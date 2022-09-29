package com.acebanenco.codewars;

public class FindOdd {

    public static int findIt(int[] arr) {
        int acc = 0;
        for (int i : arr) {
            acc = acc ^ i;
        }
        return acc;
    }
}
