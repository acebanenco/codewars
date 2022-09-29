package com.acebanenco.codewars;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindUniqueDouble {

    public static double findUniq(double[] array) {
        Map<Double, Long> counts = Arrays.stream(array)
                .boxed()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        return counts.entrySet()
                .stream()
                .filter(e ->
                        e.getValue() == 1L)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(0.0);
    }

    public static double findUniqSorted(double[] array) {
        Arrays.sort(array);

        double lastValue = array[0];
        int lastValueCount = 1;
        for (int i = 1; i < array.length; i++) {
            if ( lastValue == array[i] ) {
                lastValueCount++;
                continue;
            }
            if ( lastValueCount == 1 ) {
                return lastValue;
            }
            lastValue = array[i];
            lastValueCount = 1;
        }
        return lastValue;
    }
}
