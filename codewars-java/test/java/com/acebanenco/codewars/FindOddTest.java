package com.acebanenco.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindOddTest {

    @Test
    public void testFindId() {
        assertAll(
                () -> assertEquals(2, FindOdd.findIt(new int[]{1, 2, 1,2,2})),
                () -> assertEquals(7, FindOdd.findIt(new int[]{1, 2, 7, 2, 1}))
        );
    }

    @Test
    public void testFail() {
        assertAll(
                () -> assertEquals(7, FindOdd.findIt(new int[]{1, 2, 7, 2, 1, 1}))
        );
    }

    @Test
    public void testEmpty() {
        assertAll(
                () -> assertEquals(0, FindOdd.findIt(new int[]{}))
        );
    }

}
