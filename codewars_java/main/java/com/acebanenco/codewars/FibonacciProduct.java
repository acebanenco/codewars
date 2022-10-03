package com.acebanenco.codewars;

import java.util.stream.Stream;

public class FibonacciProduct {

    private final long product;

    public FibonacciProduct(long product) {
        this.product = product;
    }

    public boolean isProductGreaterEqual(FibonacciNumber number) {
        return getProduct(number) >= product;
    }

    private boolean isProductEqual(FibonacciNumber number) {
        return getProduct(number) == product;
    }

    public long[] getAnswer(FibonacciNumber number) {
        return new long[] {
                number.getPrevious(),
                number.getCurrent(),
                isProductEqual(number) ? 1L : 0L
        };
    }

    private long getProduct(FibonacciNumber number) {
        return number.getPrevious() * number.getCurrent();
    }

    public static long[] fibonacciProduct(long product) {
        return new FibonacciProduct(product).fibonacciProduct();
    }

    public long[] fibonacciProduct() {
        return Stream.iterate(new FibonacciNumber(), FibonacciNumber::next)
                .filter(this::isProductGreaterEqual)
                .findFirst()
                .map(this::getAnswer)
                .orElseGet(() -> new long[0]);
    }

    static class FibonacciNumber {
        private final long previous;
        private final long current;

        public FibonacciNumber() {
            this(0, 1);
        }

        public FibonacciNumber(long previous, long current) {
            this.previous = previous;
            this.current = current;
        }

        public long getPrevious() {
            return previous;
        }

        public long getCurrent() {
            return current;
        }

        public FibonacciNumber next() {
            return new FibonacciNumber(current, previous + current);
        }

    }
}
