package io.github.lgxkdream.unit11;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 540. 有序数组中的单一元素
 * @description https://leetcode-cn.com/problems/single-element-in-a-sorted-array/
 * @since 2022-02-14 22:41
 */
public class SingleElementInASortedArray {

    public static void main(String[] args) {
        /**
         * 输出: 2
         */
        System.out.println(singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        /**
         * 输出: 10
         */
        System.out.println(singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
    }

    public static int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid + 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                if (nums[mid] == nums[mid - 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return nums[left];
    }

}
