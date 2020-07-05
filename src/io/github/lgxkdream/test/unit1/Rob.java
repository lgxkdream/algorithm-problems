package io.github.lgxkdream.test.unit1;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title Rob
 * @description
 * @since 2020-03-17 10:54
 */
public class Rob {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob2(nums));
    }

    public static int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length < 2) {
            return nums[0];
        }
        int preMax = 0, curMax = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = curMax;
            curMax = Math.max(preMax + nums[i], curMax);
            preMax = temp;
        }
        int firstMax = curMax;
        preMax = 0;
        curMax = 0;
        for (int i = 1; i < nums.length; i++) {
            int temp = curMax;
            curMax = Math.max(preMax + nums[i], curMax);
            preMax = temp;
        }
        return Math.max(firstMax, curMax);
    }

    public static int rob1(int[] nums) {
        int preMax = 0, curMax = 0;
        for (int num : nums) {
            int temp = curMax;
            curMax = Math.max(preMax + num, curMax);
            preMax = temp;
        }
        return curMax;
    }

    public static int rob(int[] nums) {
        int length = nums.length;
        if (length < 1) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[length - 1];
    }

}
