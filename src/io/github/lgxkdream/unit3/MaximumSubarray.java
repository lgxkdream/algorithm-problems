package io.github.lgxkdream.unit3;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 最大子序和
 * @description
 * @since 2020-05-03 12:01
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums)); // 6
    }

    public static int maxSubArray(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] > 0 ? nums[i - 1] + nums[i] : nums[i];
            result = Math.max(result, nums[i]);
        }
        return result;
    }

    public static int maxSubArray1(int[] nums) {
        int result = nums[0], sum = 0;
        for (int num : nums) {
            result = Math.max(result, sum = Math.max(sum + num, num));
        }
        return result;
    }

}
