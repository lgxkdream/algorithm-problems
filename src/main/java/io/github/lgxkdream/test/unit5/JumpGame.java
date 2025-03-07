package io.github.lgxkdream.test.unit5;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title JumpGame
 * @description https://leetcode-cn.com/problems/jump-game/
 * @since 2020-04-17 10:04
 */
public class JumpGame {

    public static void main(String[] args) {
        // int[] nums = {2, 3, 1, 1, 4}; // true
        int[] nums = {3, 2, 1, 0, 4}; // false
        System.out.println(canJump1(nums));
    }

    public static boolean canJump1(int[] nums) {
        int distance = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= distance) {
                distance = 1;
            } else {
                distance++;
            }
        }
        return distance == 1;
    }

    public static boolean canJump(int[] nums) {
        return canJump(nums, 0);
    }

    private static boolean canJump(int[] nums, int index) {
        if (index == nums.length - 1) {
            return true;
        }
        if (index >= nums.length) {
            return false;
        }
        boolean result = false;
        for (int i = 1; i <= nums[index]; i++) {
            result = result || canJump(nums, index + i);
        }
        return result;
    }

}
