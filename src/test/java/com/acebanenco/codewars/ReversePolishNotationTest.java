package com.acebanenco.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReversePolishNotationTest {

    @Test
    public void testCalculate() {
        assertAll(
                () -> assertEquals("9", ReversePolishNotation.calculate("2", "1", "+", "3", "*")),
                () -> assertEquals("4", ReversePolishNotation.calculate("2", "13", "5", "/", "+"))
        );
    }

}