package com.acebanenco.codewars;

public class Kata {

    public static String add(String a, String b) {
        int length = Math.max(a.length(), b.length()) + 1;
        String pa = zeroPad(a, length);
        String pb = zeroPad(b, length);
        char[] result = getSumChars(pa, pb, length);
        return getSumAsString(length, result);
    }

    private static String zeroPad(String s, int length) {
        int padCount = length - s.length();
        if ( padCount <= 0 ) {
            return s;
        }
        return "0".repeat(padCount) + s;
    }

    private static char[] getSumChars(String a, String b, int length) {
        int overflow = 0;
        char[] result = new char[length];
        for (int index = length; index-- > 0; ) {
            int dc = sumDigits(a, b, index, overflow);
            result[index] = Character.forDigit(dc % 10, 10);
            overflow = dc / 10;
        }
        if ( overflow > 0 ) {
            throw new AssertionError();
        }
        return result;
    }

    private static int getStartIndex(char[] result) {
        int start = 0;
        while(result[start] == '0') {
            start++;
        }
        return start;
    }

    private static int sumDigits(String a, String b, int index, int overflow) {
        int da = Character.digit(a.charAt(index), 10);
        int db = Character.digit(b.charAt(index), 10);
        return da + db + overflow;
    }

    private static String getSumAsString(int length, char[] result) {
        int start = getStartIndex(result);
        return new String(result, start, length - start);
    }

}
