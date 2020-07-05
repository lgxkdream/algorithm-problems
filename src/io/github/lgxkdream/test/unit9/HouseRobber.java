package io.github.lgxkdream.test.unit9;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 打家劫舍
 * @description https://leetcode-cn.com/problems/house-robber/
 * @since 2020-05-29 10:03
 */
public class HouseRobber {

    public static void main(String[] args) {
        /**
         * 输出: 4
         * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
         *      偷窃到的最高金额 = 1 + 3 = 4 。
         */
        System.out.println(rob(new int[]{1, 2, 3, 1}));

        /**
         * 输出: 12
         * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
         *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
         */
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
    }

    /**
     * 动态规划 dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
     */
    public static int rob1(int[] nums) {
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

    public static int rob(int[] nums) {
        int preMax = 0, curMax = 0;
        for (int num : nums) {
            int temp = curMax;
            curMax = Math.max(preMax + num, curMax);
            preMax = temp;
        }
        return curMax;
    }

}
