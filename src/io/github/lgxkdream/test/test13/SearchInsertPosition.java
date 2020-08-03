package io.github.lgxkdream.test.test13;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 35. 搜索插入位置
 * @description https://leetcode-cn.com/problems/search-insert-position/
 * @since 2020-07-31 21:16
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        /**
         * 输出: 2
         */
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
        /**
         * 输出: 1
         */
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
        /**
         * 输出: 4
         */
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));
        /**
         * 输出: 0
         */
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 0));
        /**
         * 输出: 1
         */
        System.out.println(searchInsert(new int[]{1, 3}, 2));
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (true) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
                if (left > right) {
                    return Math.max(0, left);
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
                if (left > right) {
                    return Math.max(0, left);
                }
            } else {
                return mid;
            }
        }
    }

}
