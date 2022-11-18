package com.acebanenco.codewars;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Xbonacci {

    public double[] tribonacci(double[] s, int n) {
        double[] result = Arrays.copyOf(s, n);
        IntStream.range(s.length, result.length)
                .forEachOrdered(index ->
                        result[index] = Arrays.stream(result, index - 3, index).sum());
        return result;
    }

}
