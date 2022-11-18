package com.acebanenco.codewars;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class PickPeaksTest {


    private static String[] msg = {
            "should support empty input",
            "should support finding peaks",
            "should support finding peaks, but should ignore peaks on the edge of the array",
            "should support finding peaks; if the peak is a plateau, it should only " +
                    "return the position of the first element of the plateau",
            "should support finding peaks; if the peak is a plateau, it should only " +
                    "return the position of the first element of the plateau",
            "should support finding peaks, but should ignore peaks on the edge of the array"};

    private static int[][] array = {
            {},
            {1,2,3,6,4,1,2,3,2,1},
            {3,2,3,6,4,1,2,3,2,1,2,3},
            {3,2,3,6,4,1,2,3,2,1,2,2,2,1},
            {2,1,3,1,2,2,2,2,1},
            {2,1,3,1,2,2,2,2}};

    private static int[][] posS  = {
            {},
            {3,7},
            {3,7},
            {3,7,10},
            {2,4},
            {2},};

    private static int[][] peaksS = {
            {},
            {6,3},
            {6,3},
            {6,3,2},
            {3,2},
            {3}};

    private static Executable getExecutable(int n) {
        final int[] p1 = posS[n], p2 = peaksS[n];
        Map<String, List<Integer>> expected = new HashMap<>() {{
            put("pos", Arrays.stream(p1)
                    .boxed()
                    .collect(Collectors.toList()));
            put("peaks", Arrays.stream(p2)
                    .boxed()
                    .collect(Collectors.toList()));
        }};
        Map<String, List<Integer>> actual = PickPeaks.getPeaks(array[n]);
        String s = msg[n];
        return () -> assertEquals(expected, actual, s);
    }

    @Test
    public void sampleTests() {
        List<Executable> executables = IntStream.range(0, msg.length)
                .mapToObj(PickPeaksTest::getExecutable)
                .collect(Collectors.toList());
        assertAll(executables);
    }

}