package io.github.lgxkdream.test.unit8;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 和可被 K 整除的子数组
 * @description https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
 * @since 2020-05-27 10:00
 */
public class SubarraySumsDivisibleByK {

    public static void main(String[] args) {
        /**
         * 输出：7
         * 解释：
         * 有 7 个子数组满足其元素之和可被 K = 5 整除：
         * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
         *
         */
        System.out.println(subarraysDivByK3(new int[]{4, 5, 0, -2, -3, 1}, 5));
    }

    public static int subarraysDivByK2(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0;
        for (int elem : A) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % K + K) % K;
            record.put(modulus, record.getOrDefault(modulus, 0) + 1);
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : record.entrySet()) {
            ans += entry.getValue() * (entry.getValue() - 1) / 2;
        }
        return ans;
    }

    public static int subarraysDivByK1(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, ans = 0;
        for (int elem : A) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % K + K) % K;
            int same = record.getOrDefault(modulus, 0);
            ans += same;
            record.put(modulus, same + 1);
        }
        return ans;
    }

    /**
     * 前缀和解法
     *
     * @param A
     * @param K
     * @return
     */
    public static int subarraysDivByK3(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int result = 0, sum = 0;
        for (int a : A) {
            sum += a;
            int modulus = (sum % K + K) % K;
            if (map.containsKey(modulus)) {
                result += map.get(modulus);
            }
            map.put(modulus, map.getOrDefault(modulus, 0) + 1);
        }
        return result;
    }

    /**
     * 暴力解法，不推荐
     *
     * @param A
     * @param K
     * @return
     */
    public static int subarraysDivByK(int[] A, int K) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            for (int j = i; j < A.length; j++) {
                sum += A[j];
                if (sum % K == 0) {
                    result++;
                }
            }
        }
        return result;
    }

}
