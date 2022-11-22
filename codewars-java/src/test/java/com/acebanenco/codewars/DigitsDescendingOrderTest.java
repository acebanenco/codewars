package com.acebanenco.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigitsDescendingOrderTest {

    @Test
    public void test_01() {
        assertEquals(0, DigitsDescendingOrder.sortDesc(0));
    }

    @Test
    public void test_02() {
        assertEquals(51, DigitsDescendingOrder.sortDesc(15));
    }


    @Test
    public void test_03() {
        assertEquals(987654321, DigitsDescendingOrder.sortDesc(123456789));
    }
}