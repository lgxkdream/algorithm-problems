package io.github.lgxkdream.test.unit10;

import java.util.Arrays;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 1300. 转变数组后最接近目标值的数组和
 * @description
 * @since 2020-06-14 10:47
 */
public class SumOfMutatedArrayClosestToTarget {

    public static void main(String[] args) {
        /**
         * 输出：3
         * 解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
         */
        System.out.println(findBestValue(new int[]{4, 9, 3}, 10));
        /**
         * 输出：5
         */
        System.out.println(findBestValue(new int[]{2, 3, 5}, 10));
        /**
         * 输出：11361
         */
        System.out.println(findBestValue(new int[]{60864, 25176, 27249, 21296, 20204}, 56803));
    }

    /**
     * 数组的和 arr[0]+...+arr[i−1]+x∗(n−i)
     *
     * @param arr
     * @param target
     * @return
     */
    public static int findBestValue(int[] arr, int target) {
        int len = arr.length;
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int avg = (target - sum) / (len - i);
            if (arr[i] > avg) {
                double temp = (double) (target - sum) / (len - i);
                if (temp - avg > 0.5) {
                    return avg + 1;
                } else {
                    return avg;
                }
            }
            sum += arr[i];
        }
        return arr[len - 1];
    }

}
