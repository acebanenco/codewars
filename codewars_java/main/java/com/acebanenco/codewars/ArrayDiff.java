package com.acebanenco.codewars;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayDiff {

    public static int[] arrayDiff(int[] a, int[] b) {
        if ( a.length == 0 || b.length == 0 ) {
            return a;
        }
        Set<Integer> bSet = Arrays.stream(b)
                .boxed()
                .collect(Collectors.toSet());
        return Arrays.stream(a)
                .filter(e ->
                        !bSet.contains(e))
                .toArray();
    }
}
