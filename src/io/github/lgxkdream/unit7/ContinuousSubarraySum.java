package io.github.lgxkdream.unit7;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 523. 连续的子数组和
 * @description https://leetcode-cn.com/problems/continuous-subarray-sum/
 * @since 6/2/21 11:09 PM
 */
public class ContinuousSubarraySum {

    public static void main(String[] args) {
        /**
         * 输出：true
         * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
         */
        System.out.println(checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
        /**
         * 输出：true
         * 解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。
         * 42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
         */
        System.out.println(checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
        /**
         * 输出：false
         */
        System.out.println(checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        if (len < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0;
        for (int i = 0; i < len; i++) {
            count += nums[i];
            int remainder = count % k;
            if (map.containsKey(remainder)) {
                if (i - map.get(remainder) >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }

}
