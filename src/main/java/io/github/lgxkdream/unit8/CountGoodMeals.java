package io.github.lgxkdream.unit8;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 1711. 大餐计数
 * @description https://leetcode-cn.com/problems/count-good-meals/
 * @since 7/7/21 10:34 PM
 */
public class CountGoodMeals {

    public static void main(String[] args) {
        /**
         * 输出：4
         * 解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
         * 它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
         */
        System.out.println(countPairs(new int[]{1, 3, 5, 7, 9}));
        /**
         * 输出：15
         * 解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
         */
        System.out.println(countPairs(new int[]{1, 1, 1, 3, 3, 3, 7}));
    }

    public static int countPairs(int[] deliciousness) {
        final int MOD = 1000000007;
        int maxVal = 0;
        for (int delicious : deliciousness) {
            maxVal = Math.max(maxVal, delicious);
        }
        int maxSum = maxVal * 2;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int delicious : deliciousness) {
            for (int i = 1; i <= maxSum; i <<= 1) {
                if (map.get(i - delicious) != null) {
                    res = (res + map.get(i - delicious)) % MOD;
                }
            }
            map.put(delicious, map.getOrDefault(delicious, 0) + 1);
        }
        return res;
    }

}
