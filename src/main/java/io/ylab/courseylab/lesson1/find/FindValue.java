package io.ylab.courseylab.lesson1.find;

import java.util.Arrays;
/*
Заполните массив случайным числами и выведите
максимальное, минимальное и среднее значение.
Отсортируйте массив [5,6,3,2,5,1,4,9]
 */
public class FindValue {
    private static final long MULTIPLIER = 0x5DEECE66DL;
    private static final long ADDEND = 0xBL;
    private static final long MASK = (1L << 48) - 1;
    long seed;

    public FindValue() {
        this(8682522807148012L ^ System.nanoTime());
    }

    public FindValue(long seed) {
        this.seed = seed;
    }

    public int nextInt(int bound) {
        if (bound <= 0) {
            throw new IllegalArgumentException();
        }
        int result = next(31);
        int m = bound - 1;
        if ((bound & m) == 0) {
            result = (int) ((bound * (long) result) >> 31);
        } else {
            for (int i = result; i - (result = i % bound) + m < 0; i = next(31));
        }
        return result;
    }

    private int next(int i) {
        seed = (seed * MULTIPLIER + ADDEND) & MASK;
        return (int) (seed >>> (48 - i));
    }

    public static int findMaxValue1(int[][] nums) {
        int max = 0;
        for (int[] num : nums) {
            for (int i : num) {
                if (i > max) {
                    max = i;
                }
            }
        }
        return max;
    }

    public static int findMinValue1(int[][] nums) {
        int min = Integer.MAX_VALUE;
        for (int[] num : nums) {
            for (int i : num) {
                if (i <= min) {
                    min = i;
                }
            }
        }
        return min;
    }

    public static double findAverageArithmetic1(int[][] nums) {
        double result;
        double sum = 0;
        int amount = nums.length * nums.length;
        for (int[] num : nums) {
            for (int i : num) {
                sum += i;
            }
        }
        result = sum / amount;
        return result;
    }

    public static void main(String[] args) {
        FindValue findValue = new FindValue();
        int[][] test = new int[10][10];

        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[i].length; j++) {
                test[i][j] = findValue.nextInt(50);
                test[i][j] += findValue.nextInt(50);
            }
        }

        for (int[] ints : test) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("MaxValue is: " + FindValue.findMaxValue1(test));
        System.out.println("MinValue is: " + FindValue.findMinValue1(test));
        System.out.println("AverageArithmetic is: " + FindValue.findAverageArithmetic1(test));
    }
}
