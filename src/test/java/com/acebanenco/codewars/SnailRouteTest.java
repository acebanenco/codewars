package com.acebanenco.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnailRouteTest {

    @Test
    public void testSnailRoute1() {
        assertArrayEquals(new int[]{1,2,3,6,9,8,7,4,5}, SnailRoute.snailRoute(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}}));
    }

    @Test
    public void testSnailRoute2() {
        assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9}, SnailRoute.snailRoute(new int[][]{
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}}));
    }

    @Test
    public void testSnailRouteEmpty() {
        assertArrayEquals(new int[]{}, SnailRoute.snailRoute(new int[][]{{}}));
    }

}