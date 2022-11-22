package com.acebanenco.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciProductTest {

    @Test
    public void testFibonacciProduct() {
        assertAll(
                () -> assertArrayEquals(new long[]{21, 34, 1}, FibonacciProduct.fibonacciProduct(714)),
                () -> assertArrayEquals(new long[]{34, 55, 0}, FibonacciProduct.fibonacciProduct(800))
        );
    }
}