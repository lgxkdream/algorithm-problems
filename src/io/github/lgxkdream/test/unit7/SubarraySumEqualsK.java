package io.github.lgxkdream.test.unit7;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 和为K的子数组
 * @description https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * @since 2020-05-15 10:05
 */
public class SubarraySumEqualsK {

    public static void main(String[] args) {
        // 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum1(new int[]{-1, -1, 1}, 0));
    }

    /**
     * 前缀和。时间复杂度O(n)
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum1(int[] nums, int k) {
        /**
         * if sum(i) = sum(j) + k; result++;
         * 扫描一遍数组, 使用map记录出现同样的和的次数, 对每个i计算累计和sum并判断map内是否有sum-k
         **/
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, res = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            // 表示连续子数组减去连续子数组，必定为连续子数组
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    public static int subarraySum(int[] nums, int k) {
        int result = 0;
        if (nums == null || nums.length < 1) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            int curIndex = i;
            int curNum = 0;
            while (curIndex < nums.length) {
                curNum += nums[curIndex++];
                if (curNum == k) {
                    result++;
                }
            }
        }
        return result;
    }

}
