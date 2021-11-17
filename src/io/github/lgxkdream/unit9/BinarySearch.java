package io.github.lgxkdream.unit9;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 704. 二分查找
 * @description https://leetcode-cn.com/problems/binary-search/
 * @since 9/6/21 11:09 PM
 */
public class BinarySearch {

    public static void main(String[] args) {
        /**
         * 输出: 4
         * 解释: 9 出现在 nums 中并且下标为 4
         */
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        /**
         * 输出: -1
         * 解释: 2 不存在 nums 中因此返回 -1
         */
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
