package io.ylab.courseylab.lesson1.sort;

import java.util.Arrays;

public class CombSort {
    public static void combSort(int[] array) {
        int gap = array.length;

        boolean isSorted = false;
        while (!isSorted || gap != 1) {

            if (gap > 1) {
                gap = gap * 10 / 13; // gap / 1.3
            } else {
                gap = 1;
            }

            isSorted = true;
            for (int i = gap; i < array.length; i++) {
                if (array[i - gap] > array[i]) {
                    swap(array, gap, i);
                    isSorted = false;
                }
            }
        }
    }

    private static void swap(int[] array, int gap, int i) {
        int tmp = array[i];
        array[i] = array[i - gap];
        array[i - gap] = tmp;
    }

    public static void main(String[] args) {
        int[] arrayToSort = {5, 6, 3, 2, 5, 1, 4, 9};
        combSort(arrayToSort);
        System.out.println(Arrays.toString(arrayToSort));
    }
}
