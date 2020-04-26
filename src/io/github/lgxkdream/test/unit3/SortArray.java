package io.github.lgxkdream.test.unit3;

import java.util.Arrays;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title SortArray
 * @description 冒泡、选择、快速排序
 * @since 2020-03-31 09:46
 */
public class SortArray {

    public static void main(String[] args) {
        int[] nums = {5, 1, 1, 2, 0, 0};
        Arrays.stream(sortArray2(nums))
                .forEach(System.out::println);
    }

    public static int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    nums[j] = nums[j] ^ nums[j + 1];
                    nums[j + 1] = nums[j] ^ nums[j + 1];
                    nums[j] = nums[j] ^ nums[j + 1];
                }
            }
        }
        return nums;
    }

    public static int[] sortArray1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    nums[i] = nums[i] ^ nums[j];
                    nums[j] = nums[i] ^ nums[j];
                    nums[i] = nums[i] ^ nums[j];
                }
            }
        }
        return nums;
    }

    public static int[] sortArray2(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int i = left, j = right, x = nums[left];
            while (i < j) {
                while (i < j && nums[j] >= x) {
                    j--;
                }
                if (i < j) {
                    nums[i++] = nums[j];
                }
                while (i < j && nums[i] <= x) {
                    i++;
                }
                if (i < j) {
                    nums[j--] = nums[i];
                }
            }
            nums[i] = x;
            quickSort(nums, left, i - 1);
            quickSort(nums, i + 1, right);
        }
    }

}
