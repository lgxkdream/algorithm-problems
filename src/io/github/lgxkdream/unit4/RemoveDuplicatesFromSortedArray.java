package io.github.lgxkdream.unit4;

import java.util.Arrays;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 26. 删除有序数组中的重复项
 * @description https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @since 4/18/21 7:00 PM
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        /**
         * 输出：2, nums = [1,2]
         * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
         */
        int[] nums = new int[]{1, 1, 2};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
        /**
         * 输出：5, nums = [0,1,2,3,4]
         * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
         */
        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 双指针
     */
    public static int removeDuplicates(int[] nums) {
        int l = nums.length;
        if (l == 0) {
            return 0;
        }
        int slow = 0;
        for (int fast = 0; fast < l; fast++) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }

}
