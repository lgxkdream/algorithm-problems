package io.github.lgxkdream.unit8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 645. 错误的集合
 * @description https://leetcode-cn.com/problems/set-mismatch/
 * @since 7/4/21 11:30 PM
 */
public class SetMismatch {

    public static void main(String[] args) {
        /**
         * 输出：[2,3]
         */
        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 2, 2, 4})));
        /**
         * 输出：[1,2]
         */
        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 1})));
    }

    public static int[] findErrorNums(int[] nums) {
        int repeat = 0, miss = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.get(i + 1) == null) {
                miss = i + 1;
            } else if (map.get(i + 1) == 2) {
                repeat = i + 1;
            }
        }
        return new int[]{repeat, miss};
    }

}
