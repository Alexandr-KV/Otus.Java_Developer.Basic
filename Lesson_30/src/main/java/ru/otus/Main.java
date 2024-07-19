package ru.otus;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

    }

    public static int[] arrayAfterLastUnit(int[] array) throws RuntimeException {
        int indexOfLastUnit = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                indexOfLastUnit = i;
            }
        }
        if (indexOfLastUnit == -1) {
            throw new RuntimeException();
        }
        return Arrays.copyOfRange(array, indexOfLastUnit + 1, array.length);
    }

    public static boolean isArrayOfOnesAndTwos(int[] array) {
        boolean containsOne = false;
        boolean containsTwo = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                containsOne = true;
            } else if (array[i] == 2) {
                containsTwo = true;
            } else {
                return false;
            }
        }
        return containsOne && containsTwo;
    }
}