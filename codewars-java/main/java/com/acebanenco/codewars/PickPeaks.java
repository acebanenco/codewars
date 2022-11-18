package com.acebanenco.codewars;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PickPeaks {

    public static Map<String, List<Integer>> getPeaks(int[] arr) {
        List<Integer> pos = getPeakIndexes(arr);
        List<Integer> peaks = pos.stream()
                .map(i -> arr[i])
                .collect(Collectors.toList());
        return new HashMap<>(Map.of(
                "pos", pos,
                "peaks", peaks
        ));
    }

    private static List<Integer> getPeakIndexes(int[] arr) {
        if (arr.length <= 0) {
            return List.of();
        }
        int[] delta = buildDeltas(arr);
        return findPeakIndexesByDelta(delta);
    }

    private static List<Integer> findPeakIndexesByDelta(int[] delta) {
        return IntStream.range(0, delta.length)
                .filter(index -> delta[index] == -1)
                .map(index -> findPeakAt(delta, index))
                .filter(peakIndex -> peakIndex >= 0)
                .map(peakIndex -> peakIndex + 1)
                .boxed()
                .collect(Collectors.toList());
    }

    private static int findPeakAt(int[] delta, int index) {
        int peakStart = index - 1;
        while (peakStart >= 0 && delta[peakStart] == 0) {
            peakStart--;
        }
        if (peakStart < 0 || delta[peakStart] == -1) {
            return -1;
        }
        return peakStart;
    }

    private static int[] buildDeltas(int[] arr) {
        int[] delta = new int[arr.length - 1];
        for (int index = 0; index < delta.length; index++) {
            delta[index] = Integer.signum(arr[index + 1] - arr[index]);
        }
        return delta;
    }
}
