package io.github.lgxkdream.test.unit12;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 41. 缺失的第一个正数
 * @description https://leetcode-cn.com/problems/first-missing-positive/
 * @since 2020-06-27 16:35
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        /**
         * 输出: 3
         */
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
        /**
         * 输出: 2
         */
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
        /**
         * 输出: 1
         */
        System.out.println(firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }

    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        // 找出非正数，设置为 len + 1
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0) {
                nums[i] = len + 1;
            }
        }
        // 将小于等于len的正数标记为负值
        for (int i = 0; i < len; i++) {
            int abs = Math.abs(nums[i]);
            if (abs <= len) {
                nums[abs - 1] = -Math.abs(nums[abs - 1]);
            }
        }
        // 非负值即为缺失的正数
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        // 没有缺失，则长度len+1为最大正数
        return len + 1;
    }

}
