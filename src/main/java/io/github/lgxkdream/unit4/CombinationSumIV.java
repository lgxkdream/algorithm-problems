package io.github.lgxkdream.unit4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 377. 组合总和 Ⅳ
 * @description
 * @since 4/24/21 11:40 PM
 */
public class CombinationSumIV {

    public static void main(String[] args) {
        /**
         * 输出：7
         * 解释：
         * 所有可能的组合为：
         * (1, 1, 1, 1)
         * (1, 1, 2)
         * (1, 2, 1)
         * (1, 3)
         * (2, 1, 1)
         * (2, 2)
         * (3, 1)
         * 请注意，顺序不同的序列被视作不同的组合。
         */
        System.out.println(combinationSum4(new int[]{1, 2, 3}, 4));
        /**
         * 输出：0
         */
        System.out.println(combinationSum4(new int[]{9}, 3));
    }

    /**
     * 动态规划
     */
    public static int combinationSum41(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        Arrays.sort(nums);
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num > i) {
                    break;
                }
                dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }

    /**
     * 递归
     */
    public static int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        return combinationSum4(nums, target, map);
    }

    private static int combinationSum4(int[] nums, int target, Map<Integer, Integer> map) {
        if (target == 0) {
            return 1;
        }
        if (map.containsKey(target)) {
            return map.get(target);
        }
        int res = 0;
        for (int num : nums) {
            if (num <= target) {
                res += combinationSum4(nums, target - num, map);
            }
        }
        map.put(target, res);
        return res;
    }

}
