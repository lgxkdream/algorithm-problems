package io.github.lgxkdream.unit8;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 930. 和相同的二元子数组
 * @description https://leetcode-cn.com/problems/binary-subarrays-with-sum/
 * @since 7/8/21 11:38 PM
 */
public class BinarySubarraysWithSum {

    public static void main(String[] args) {
        /**
         * 输出：4
         * 解释：
         * 有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
         */
        System.out.println(numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
        /**
         * 输出：15
         */
        System.out.println(numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int num : nums) {
            sum += num;
            res += map.getOrDefault(sum - goal, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

}
