package com.acebanenco.codewars;

public class ReversePolishNotation {

    public static String calculate(String...operands) {
        int[] stack = new int[10];
        int stackPointer = -1; // stack is empty

        for (String operand : operands) {
            switch (operand) {
                case "+" -> {
                    stack[stackPointer - 1] += stack[stackPointer];
                    stackPointer--;
                }
                case "-" -> {
                    stack[stackPointer - 1] -= stack[stackPointer];
                    stackPointer--;
                }
                case "*" -> {
                    stack[stackPointer - 1] *= stack[stackPointer];
                    stackPointer--;
                }
                case "/" -> {
                    stack[stackPointer - 1] /= stack[stackPointer];
                    stackPointer--;
                }
                case "%" -> {
                    stack[stackPointer - 1] %= stack[stackPointer];
                    stackPointer--;
                }
                default -> stack[++stackPointer] = Integer.parseInt(operand);
            }
        }
        return Integer.toString(stack[stackPointer]);
    }
}
