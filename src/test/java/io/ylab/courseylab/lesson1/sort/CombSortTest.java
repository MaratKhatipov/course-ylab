package io.ylab.courseylab.lesson1.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CombSortTest {

    @Test
    void whenOnlyOneNumIsDifferentThenOk() {
        int[] arr = {2, 1, 1, 1, 1, 1, 1};
        CombSort.combSort(arr);
        int[] expected = {1, 1, 1, 1, 1, 1, 2};
        Assertions.assertArrayEquals(expected, arr);
    }

    @Test
    void whenThereAreNegativeNumbers() {
        int[] arr = {15, -13, 12, 10, 2, 4, -12, -13, 1, 0};
        CombSort.combSort(arr);
        int[] expected = {-13, -13, -12, 0, 1, 2, 4, 10, 12, 15};
        Assertions.assertArrayEquals(expected, arr);
    }

    @Test
    void whenNumbersIsTheSame() {
        int[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        CombSort.combSort(arr);
        int[] expected = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Assertions.assertArrayEquals(expected, arr);
    }
}