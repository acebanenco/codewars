package com.acebanenco.codewars;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class XbonacciTest {
    private Xbonacci variabonacci;

    private final double precision = 1e-10;

    @BeforeEach
    public void setUp() {
        variabonacci = new Xbonacci();
    }

    @AfterEach
    public void tearDown() {
        variabonacci = null;
    }

    @Test
    public void sampleTests() {
        Assertions.assertAll(
                () -> assertArrayEquals(new double[]{1, 1, 1, 3, 5, 9, 17, 31, 57, 105},
                        variabonacci.tribonacci(new double[]{1, 1, 1}, 10), precision),
                () -> assertArrayEquals(new double[]{0, 0, 1, 1, 2, 4, 7, 13, 24, 44},
                        variabonacci.tribonacci(new double[]{0, 0, 1}, 10), precision),
                () -> assertArrayEquals(new double[]{0, 1, 1, 2, 4, 7, 13, 24, 44, 81},
                        variabonacci.tribonacci(new double[]{0, 1, 1}, 10), precision)
        );
    }
}
