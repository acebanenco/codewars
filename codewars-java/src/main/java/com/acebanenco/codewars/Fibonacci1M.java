package com.acebanenco.codewars;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fibonacci1M {

    public static BigInteger fib(BigInteger n) {
        return fibonacci(n);
    }

    public static BigInteger fibonacci(BigInteger n) {
        int compareResult = n.compareTo(BigInteger.ZERO);
        if ( compareResult == 0 ) {
            return BigInteger.ZERO;
        } else if ( compareResult > 0 ) {
            FibPair pair = FibPair.nth(n);
            return pair.current;
        } else {
            BigInteger minusNFibonacci = fibonacci(n.negate());
            return n.testBit(0) ? minusNFibonacci : minusNFibonacci.negate();
        }
    }

    static class FibPair {
        private final BigInteger previous;
        private final BigInteger current;

        FibPair(BigInteger previous, BigInteger current) {
            this.previous = previous;
            this.current = current;
        }

        FibPair square() {
            return new FibPair(
                    previous.multiply(previous)
                            .add(current.multiply(current)),
                    previous.shiftLeft(1)
                            .add(current)
                            .multiply(current));
        }

        FibPair next() {
            return new FibPair(current, previous.add(current));
        }

        static FibPair nth(BigInteger n) {
            FibPair pair = new FibPair(BigInteger.ZERO, BigInteger.ONE);
            if ( BigInteger.ONE.equals(n) ) {
                return pair;
            }

            List<BigInteger> numbers = new ArrayList<>();
            while ( !n.equals(BigInteger.ONE) ) {
                numbers.add(n);
                n = n.shiftRight(1);
            }
            Collections.reverse(numbers);

            for (BigInteger number : numbers) {
                FibPair square = pair.square();
                pair = number.testBit(0)
                        ? square.next()
                        : square;
            }
            return pair;
        }
    }
}
