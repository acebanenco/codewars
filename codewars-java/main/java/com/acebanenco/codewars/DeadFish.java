package com.acebanenco.codewars;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.IntUnaryOperator;

public class DeadFish {

    private final List<Integer> result = new ArrayList<>();
    private final Map<Character, IntUnaryOperator> actions = Map.of(
            'i', i -> i + 1,
            'd', i -> i - 1,
            's', i -> i * i,
            'o', i -> {
                result.add(i);
                return i;
            }
    );

    public void execute(String data) {
        int value = 0;
        for (int index = 0; index < data.length(); index++) {
            char command = data.charAt(index);
            value = execute(command, value);
        }
    }

    public int execute(char command, int value) {
        IntUnaryOperator action = actions.get(command);
        if ( action == null ) {
            return value;
        }
        return action.applyAsInt(value);
    }

    private int[] getResultAsInts() {
        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static int[] parse(String data) {
        DeadFish deadfish = new DeadFish();
        deadfish.execute(data);
        return deadfish.getResultAsInts();
    }
}
