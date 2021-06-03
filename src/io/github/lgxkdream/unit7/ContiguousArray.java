package io.github.lgxkdream.unit7;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 525. 连续数组
 * @description https://leetcode-cn.com/problems/contiguous-array/
 * @since 6/3/21 10:58 PM
 */
public class ContiguousArray {

    public static void main(String[] args) {
        /**
         * 输出: 2
         * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
         */
        System.out.println(findMaxLength(new int[]{0, 1}));
        /**
         * 输出: 2
         * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
         */
        System.out.println(findMaxLength(new int[]{0, 1, 0}));
    }

    /**
     * 前缀和 + 哈希表
     */
    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                sum += 1;
            } else {
                sum -= 1;
            }
            if (map.containsKey(sum)) {
                res = Math.max(res, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return res;
    }

}
