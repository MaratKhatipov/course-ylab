package io.ylab.courseylab.lesson1;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;
/*
Заполните массив случайным числами и выведите
максимальное, минимальное и среднее значение.
Отсортируйте массив [5,6,3,2,5,1,4,9]
 */
public class Lesson1 {
    public static int findMaxValue1(int[] nums) {
        int max = 0;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static int findMaxValue2(int[] nums) {
        return Arrays.stream(nums).max().orElseThrow(NoSuchElementException::new);
    }

    public static int findMinValue1(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) {
                min = num;
            }
        }
        return min;
    }

    public static int findMinValue2(int[] nums) {
        return Arrays.stream(nums).min().orElseThrow(NoSuchElementException::new);
    }

    public static double findAverageArithmetic1(int[] nums) {
        double result;
        double sum = 0;
        for (int num : nums) {
            sum += num;
        }
        result = sum / nums.length;
        return result;
    }

    public static double findAverageArithmetic2(int[] nums) {
        double result;
        double count = Arrays.stream(nums).count();
        double sum = Arrays.stream(nums).sum();
        result = sum / count;
        return result;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(15);
            nums[i] *= random.nextInt(8);
        }
        System.out.println(Arrays.toString(nums));
        System.out.println("findMaxValue1 - " + findMaxValue1(nums));
        System.out.println("findMaxValue2 - " + findMaxValue2(nums));
        System.out.println("findMinValue1 - " + findMinValue1(nums));
        System.out.println("findMinValue2 - " + findMinValue2(nums));
        System.out.println("findAverageArithmetic1 - " + findAverageArithmetic1(nums));
        System.out.println("findAverageArithmetic2 - " + findAverageArithmetic2(nums));
    }
}
