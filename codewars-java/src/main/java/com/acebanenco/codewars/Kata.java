package com.acebanenco.codewars;

import java.util.stream.IntStream;

import static java.lang.Math.addExact;

public class Kata {

    public static String add(String a, String b) {
        int length = Math.max(a.length(), b.length()) + 1;

        int digitsPerInt = 9;
        String[] pa = zeroPadAndSplit(a, length, digitsPerInt);
        String[] pb = zeroPadAndSplit(b, length, digitsPerInt);
        String[] result = getSumChars(pa, pb, digitsPerInt);
        return getSumAsString(result);
    }

    private static int pow10(int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= 10;
        }
        return result;
    }

    private static String[] zeroPadAndSplit(String s, int length, int groupLength) {
        int nGroups = (length + groupLength - 1) / groupLength;
        int fullLength = nGroups * groupLength;
        String padded = zeroPad(s, fullLength);
        return IntStream.range(0, nGroups)
                .mapToObj(group ->
                        padded.substring(group * groupLength, (group + 1) * groupLength))
                .toArray(String[]::new);
    }

    private static String zeroPad(String s, int length) {
        int padCount = length - s.length();
        if (padCount <= 0) {
            return s;
        }
        return "0".repeat(padCount) + s;
    }

    private static String[] getSumChars(String[] a, String[] b, int groupLength) {
        int factor = pow10(groupLength);
        int overflow = 0;
        String[] result = new String[a.length];
        for (int index = result.length; index-- > 0; ) {
            int dc = sumDigits(a[index], b[index], overflow);
            result[index] = zeroPad(Integer.toString(dc % factor, 10), groupLength);
            overflow = dc / factor;
        }
        if (overflow > 0) {
            throw new AssertionError();
        }
        return result;
    }

    private static int getStartIndex(String result) {
        int start = 0;
        while (result.charAt(start) == '0') {
            start++;
        }
        return start;
    }

    private static int sumDigits(String a, String b, int overflow) {
        int da = Integer.parseInt(a, 10);
        int db = Integer.parseInt(b, 10);
        int dc = addExact(da, db);
        return addExact(dc, overflow);
    }

    private static String getSumAsString(String[] components) {
        String result = String.join("", components);
        int start = getStartIndex(result);
        return result.substring(start);
    }

}
