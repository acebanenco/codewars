package com.acebanenco.codewars;

import java.util.Arrays;
import java.util.Map;

// https://www.codewars.com/kata/54da539698b8a2ad76000228/java
public class TenMinWalk {

    public static boolean isValid(char[] walk) {
        int expectedLength = 10;
        if (walk.length != expectedLength) {
            return false;
        }
        Map<String, int[]> vectors = Map.of(
                "n", new int[]{0, 1},
                "s", new int[]{0, -1},
                "w", new int[]{-1, 0},
                "e", new int[]{1, 0}
        );
        String[] route = new String(walk).split("");

        if (!routeElementsAreValid(vectors, route)) {
            return false;
            //throw new IllegalArgumentException("Route should have elements 'n', 's', 'w', 'e'");
        }

        int[] sumOfVectors = routeSumVector(vectors, route);
        return isZeroVector(sumOfVectors);
    }

    private static boolean routeElementsAreValid(Map<String, int[]> vectors, String[] route) {
        return Arrays.stream(route)
                .allMatch(vectors::containsKey);
    }

    private static int[] routeSumVector(Map<String, int[]> vectors, String[] route) {
        return Arrays.stream(route)
                .map(vectors::get)
                .reduce(new int[]{0, 0}, TenMinWalk::sumVectors);
    }

    private static boolean isZeroVector(int[] sumOfVectors) {
        return sumOfVectors[0] == 0 && sumOfVectors[1] == 0;
    }

    private static int[] sumVectors(int[] vec1, int[] vec2) {
        return new int[]{vec1[0] + vec2[0], vec1[1] + vec2[1]};
    }
}
