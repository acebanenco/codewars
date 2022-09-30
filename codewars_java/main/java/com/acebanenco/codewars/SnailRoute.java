package com.acebanenco.codewars;

import java.util.BitSet;

public class SnailRoute {

    enum Direction {
        EAST, SOUTH, WEST, NORTH
    }

    public static int[] snailRoute(int[][] array) {
        if ( array.length == 0 || array[0].length == 0 ) {
            return new int[0];
        }
        int length = array[0].length;

        BitSet visited = new BitSet(length * length);
        Direction direction = Direction.EAST;
        int x = 0;
        int y = 0;

        int[] route = new int[length * length];
        int routeIndex = 0;

        do {
            setVisited(visited, x, y, length);
            route[routeIndex++] = array[y][x];

            if (canMove(visited, x, y, length, direction)) {
                x = moveX(x, direction);
                y = moveY(y, direction);
                continue;
            }
            direction = turnRight(direction);
            if (!canMove(visited, x, y, length, direction)) {
                break;
            }
            x = moveX(x, direction);
            y = moveY(y, direction);
        } while (true);
        return route;
    }

    private static void setVisited(BitSet visited, int x, int y, int length) {
        visited.set(x + y * length);
    }

    private static boolean isVisited(BitSet visited, int x, int y, int length) {
        return visited.get(x + y * length);
    }

    private static Direction turnRight(Direction direction) {
        return switch (direction) {
            case EAST -> Direction.SOUTH;
            case SOUTH -> Direction.WEST;
            case WEST -> Direction.NORTH;
            case NORTH -> Direction.EAST;
        };
    }

    private static int moveX(int x, Direction direction) {
        return switch (direction) {
            case EAST -> x + 1;
            case WEST -> x - 1;
            default -> x;
        };
    }

    private static int moveY(int y, Direction direction) {
        return switch (direction) {
            case SOUTH -> y + 1; // east
            case NORTH -> y - 1; // west
            default -> y;
        };
    }

    private static boolean canMove(BitSet visited, int x, int y, int length, Direction direction) {
        x = moveX(x, direction);
        y = moveY(y, direction);
        if (x < 0 || x >= length || y < 0 || y >= length) {
            return false;
        }
        return !isVisited(visited, x, y, length);
    }

}
