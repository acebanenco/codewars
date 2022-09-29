package com.acebanenco.codewars;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TwoSum {

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> indicesMap = buildNumberToLastIndexMap(numbers);
        return IntStream.range(0, numbers.length)
                .mapToObj(index -> {
                            int other = target - numbers[index];
                            int otherIndex = completionIndex(indicesMap, other);
                            return new int[]{index, otherIndex};
                        }
                )
                // filter found matches except when indexes are matching
                .filter(tuple -> tuple[1] >= 0 && tuple[0] != tuple[1])
                .findFirst()
                .orElseGet(() -> new int[]{-1, -1});
    }

    private static Map<Integer, Integer> buildNumberToLastIndexMap(int[] numbers) {
        return IntStream.range(0, numbers.length)
                .mapToObj(index ->
                        new int[]{numbers[index], index})
                .collect(Collectors.toMap(
                        tuple -> tuple[0],
                        tuple -> tuple[1],
                        Math::max));
    }

    private static int completionIndex(Map<Integer, Integer> indices, int number) {
        return indices.getOrDefault(number, -1);
    }

    public static int[] twoSumBruteForce(int[] numbers, int target) {
        return pairsOfRange(numbers.length)
                .filter(tuple ->
                        matches(numbers, target, tuple))
                .findFirst()
                .orElseGet(() ->
                        new int[]{-1, -1});
    }

    private static boolean matches(int[] numbers, int target, int[] tuple) {
        int i = tuple[0];
        int j = tuple[1];
        return matches(numbers[i], numbers[j], target);
    }

    private static boolean matches(int k, int l, int target) {
        return k + l == target;
    }

    private static Stream<int[]> pairsOfRange(int to) {
        return IntStream.range(0, to)
                .mapToObj(start ->
                        IntStream.range(start + 1, to)
                                .mapToObj(index ->
                                        new int[]{start, index}))
                .flatMap(Function.identity());
    }

}
