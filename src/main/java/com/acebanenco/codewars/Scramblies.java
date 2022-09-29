package com.acebanenco.codewars;

// https://www.codewars.com/kata/55c04b4cc56a697bb0000048/train/java

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * Complete the function scramble(str1, str2) that returns true if a portion of str1 characters can be rearranged to match str2, otherwise returns false.
 * <p>
 * Notes:
 * <p>
 * Only lower case letters will be used (a-z). No punctuation or digits will be included.
 * Performance needs to be considered.
 * Examples
 * scramble('rkqodlw', 'world') ==> True
 * scramble('cedewaraaossoqqyt', 'codewars') ==> True
 * scramble('katas', 'steak') ==> False
 */
public class Scramblies {

    public static boolean scramble(String str1, String str2) {
        return scrambleUsingSort(str1, str2);
    }

    public static boolean scrambleUsingHash(String str1, String str2) {
        Map<Integer, Long> map1 = charCountMap(str1);
        Map<Integer, Long> map2 = charCountMap(str2);
        return map2.entrySet()
                .stream()
                .noneMatch(en2 -> valueIsGreater(en2, map1));
    }

    private static Map<Integer, Long> charCountMap(String str) {
        return str.chars()
                .boxed()
                .collect(groupingBy(
                        Function.identity(),
                        Collectors.counting()));
    }

    private static boolean valueIsGreater(
            Map.Entry<Integer, Long> entry,
            Map<Integer, Long> charCountMap) {
        Integer key = entry.getKey();
        long value = entry.getValue();
        long mapValue = charCountMap.getOrDefault(key, 0L);
        return value > mapValue;
    }

    public static boolean scrambleUsingSort(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        Arrays.sort(arr1);

        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr2);

        // merge sorted

        int it2 = 0;
        for (int it1 = 0; it1 < arr1.length && it2 < arr2.length; it1++) {
            char ch2 = arr2[it2];
            char ch1 = arr1[it1];
            if (ch2 < ch1) {
                // ch2 not found in str1
                break;
            }
            if (ch2 == ch1) {
                // advance to the next search char
                it2++;
            }
        }
        return it2 == arr2.length;
    }
}
