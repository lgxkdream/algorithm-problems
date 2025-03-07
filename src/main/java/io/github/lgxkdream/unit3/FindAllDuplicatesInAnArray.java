package io.github.lgxkdream.unit3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 442. 数组中重复的数据
 * @description https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
 * @since 2022-05-08 08:13
 */
public class FindAllDuplicatesInAnArray {

    public static void main(String[] args) {
        /**
         * 输出：[2,3]
         */
        System.out.println(findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        /**
         * 输出：[1]
         */
        System.out.println(findDuplicates(new int[]{1, 1, 2}));
        /**
         * 输出：[]
         */
        System.out.println(findDuplicates(new int[]{1}));
        /**
         * 输出：[9,5,6]
         */
        System.out.println(findDuplicates(new int[]{5, 4, 6, 7, 9, 3, 10, 9, 5, 6}));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(nums[i]);
            }
        }
        return res;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
