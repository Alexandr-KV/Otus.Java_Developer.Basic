package ru.otus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void testArrayAfterLastUnit() {
        Assertions.assertArrayEquals(new int[]{2, 2}, Main.arrayAfterLastUnit(new int[]{1, 2, 1, 2, 2}));
        Assertions.assertThrows(RuntimeException.class, () -> Main.arrayAfterLastUnit(new int[]{2, 2, 2, 2}));
    }

    @Test
    public void testIsArrayOfOnesAndTwos() {
        Assertions.assertTrue(Main.isArrayOfOnesAndTwos(new int[]{1,2}));
        Assertions.assertFalse(Main.isArrayOfOnesAndTwos(new int[]{1,1}));
        Assertions.assertFalse(Main.isArrayOfOnesAndTwos(new int[]{1,3}));
        Assertions.assertTrue(Main.isArrayOfOnesAndTwos(new int[]{1,2,2,1}));
    }

}