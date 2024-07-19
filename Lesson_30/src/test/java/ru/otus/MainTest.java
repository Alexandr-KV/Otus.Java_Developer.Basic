package ru.otus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MainTest {

    @Test
    public void testArrayAfterLastUnit() {
        Assertions.assertArrayEquals(new int[]{2, 2}, Main.arrayAfterLastUnit(new int[]{1, 2, 1, 2, 2}));
    }

    @Test
    public void testRuntimeExceptionArrayAfterLastUnit() {
        Assertions.assertThrows(RuntimeException.class, () -> Main.arrayAfterLastUnit(new int[]{2, 2, 2, 2}));
    }

    @ParameterizedTest
    @MethodSource("testIsArrayOfOnesAndTwosTrue")
    public void testIsArrayOfOnesAndTwosTrue(int[] arr) {
        Assertions.assertTrue(Main.isArrayOfOnesAndTwos(arr));
    }

    public static Stream<Arguments> testIsArrayOfOnesAndTwosTrue() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 2}));
        out.add(Arguments.arguments(new int[]{1, 2, 2, 1}));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("testIsArrayOfOnesAndTwosFalse")
    public void testIsArrayOfOnesAndTwosFalse(int[] arr) {
        Assertions.assertFalse(Main.isArrayOfOnesAndTwos(arr));
    }

    public static Stream<Arguments> testIsArrayOfOnesAndTwosFalse() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 1}));
        out.add(Arguments.arguments(new int[]{1, 3}));
        return out.stream();
    }

}