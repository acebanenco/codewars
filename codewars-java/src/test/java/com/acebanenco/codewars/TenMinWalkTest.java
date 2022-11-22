package com.acebanenco.codewars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.acebanenco.codewars.TenMinWalk.isValid;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TenMinWalkTest {

    @Test
    public void testIsClosedWalk10() {
        Assertions.assertAll(
                () -> assertTrue(isValid("nswenswens".toCharArray())),
                () -> assertFalse(isValid("nswenswenn".toCharArray())),
                () -> assertFalse(isValid("nswenswen".toCharArray()))
        );
    }
}
