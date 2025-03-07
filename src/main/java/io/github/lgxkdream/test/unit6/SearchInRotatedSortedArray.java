package io.github.lgxkdream.test.unit6;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 搜索旋转排序数组
 * @description https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * @since 2020-04-27 10:05
 */
public class SearchInRotatedSortedArray {

    /**
     * 二分查找思想
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        // int[] nums = {5, 1, 3};
        int target = 1;
        System.out.println(search(nums, target));
    }

    /**
     * 优解
     *
     * @param nums
     * @param left
     * @param right
     * @param target
     * @return
     */
    public int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[left] <= nums[mid]) {
            // 如果左半部分有序
            if (nums[left] <= target && target <= nums[mid]) {
                // 查找元素在左半部分
                return binarySearch(nums, left, mid, target);
            } else {
                // 查找元素在右半部分
                return binarySearch(nums, mid + 1, right, target);
            }
        } else {
            if (nums[mid] <= target && target <= nums[right]) {
                return binarySearch(nums, mid, right, target);
            } else {
                return binarySearch(nums, left, mid - 1, target);
            }
        }
    }

    /**
     * 次解
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int result = -1;
        while (left <= right && result == -1) {
            int mid = (left + right) / 2;
            if (nums[left] <= nums[mid]) {
                result = search(nums, left, mid, target);
                left = mid + 1;
            } else {
                result = search(nums, mid + 1, right, target);
                right = mid;
            }
        }
        return result;
    }

    private static int search(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] < target) {
            left = mid + 1;
            return search(nums, left, right, target);
        } else if (nums[mid] > target) {
            right = mid - 1;
            return search(nums, left, right, target);
        } else {
            return mid;
        }
    }

}
