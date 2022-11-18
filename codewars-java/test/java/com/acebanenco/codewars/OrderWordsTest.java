package com.acebanenco.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderWordsTest {
    @Test
    public void test1() {
        assertEquals("Thi1s is2 3a T4est", OrderWords.orderWords("is2 Thi1s T4est 3a"));
    }

    @Test
    public void test2() {
        assertEquals("Fo1r the2 g3ood 4of th5e pe6ople", OrderWords.orderWords("4of Fo1r pe6ople g3ood th5e the2"));
    }

    @Test
    public void test3() {
        assertEquals("", OrderWords.orderWords(""));
    }
}