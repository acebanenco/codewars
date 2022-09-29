package com.acebanenco.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FindUniqueDoubleTest {

    @Test
    public void testFindUniq() {
        assertAll(
                () -> assertEquals(2.0, FindUniqueDouble.findUniq(new double[]{ 1, 1, 1, 2, 1, 1 })),
                () -> assertEquals(0.55, FindUniqueDouble.findUniq(new double[]{ 0, 0, 0.55, 0, 0 }))
        );
    }

}