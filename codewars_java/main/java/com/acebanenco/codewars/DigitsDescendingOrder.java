package com.acebanenco.codewars;

import java.util.stream.IntStream;

public class DigitsDescendingOrder {

    public static int sortDesc(final int num) {
        int[] count = numToCounts(num);
        return sortedNumFromCounts(count);
    }

    private static int[] numToCounts(int num) {
        int[] count = new int[10];
        IntStream.iterate(num, digits -> digits > 0, digits -> digits / 10)
                .map(digits -> digits%10)
                .forEach(digit -> count[digit]++);
        return count;
    }

    private static int sortedNumFromCounts(int[] count) {
        int[] result = {0,1};
        for (int digit = 0; digit < count.length; digit++) {
            for(int i = 0; i < count[digit]; i++) {
                result[0] += digit * result[1];
                result[1] *= 10;
            }
        }
        return result[0];
    }

}
