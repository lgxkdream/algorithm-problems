package io.github.lgxkdream.unit5;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 1482. 制作 m 束花所需的最少天数
 * @description https://leetcode-cn.com/problems/minimum-number-of-days-to-make-m-bouquets/
 * @since 5/9/21 9:35 PM
 */
public class MinimumNumberOfDaysToMakeMBouquets {

    public static void main(String[] args) {
        /**
         * 输出：3
         * 解释：让我们一起观察这三天的花开过程，x 表示花开，而 _ 表示花还未开。
         * 现在需要制作 3 束花，每束只需要 1 朵。
         * 1 天后：[x, _, _, _, _]   // 只能制作 1 束花
         * 2 天后：[x, _, _, _, x]   // 只能制作 2 束花
         * 3 天后：[x, _, x, _, x]   // 可以制作 3 束花，答案为 3
         */
        System.out.println(minDays(new int[]{1, 10, 3, 10, 2}, 3, 1));
        /**
         * 输出：-1
         * 解释：要制作 3 束花，每束需要 2 朵花，也就是一共需要 6 朵花。而花园中只有 5 朵花，无法满足制作要求，返回 -1 。
         */
        System.out.println(minDays(new int[]{1, 10, 3, 10, 2}, 3, 2));
        /**
         * 输出：12
         * 解释：要制作 2 束花，每束需要 3 朵。
         * 花园在 7 天后和 12 天后的情况如下：
         * 7 天后：[x, x, x, x, _, x, x]
         * 可以用前 3 朵盛开的花制作第一束花。但不能使用后 3 朵盛开的花，因为它们不相邻。
         * 12 天后：[x, x, x, x, x, x, x]
         * 显然，我们可以用不同的方式制作两束花。
         */
        System.out.println(minDays(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3));
        /**
         * 输出：1000000000
         * 解释：需要等 1000000000 天才能采到花来制作花束
         */
        System.out.println(minDays(new int[]{1000000000, 1000000000}, 1, 1));
        /**
         * 输出：9
         */
        System.out.println(minDays(new int[]{1, 10, 2, 9, 3, 8, 4, 7, 5, 6}, 4, 2));
    }

    /**
     * 二分查找思想
     */
    public static int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) {
            return -1;
        }
        int min = Integer.MAX_VALUE, max = 0;
        for (int d : bloomDay) {
            min = Math.min(min, d);
            max = Math.max(max, d);
        }
        while (min < max) {
            int mid = min + (max - min) / 2;
            if (canMake(bloomDay, mid, m, k)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return max;
    }

    private static boolean canMake(int[] bloomDay, int days, int m, int k) {
        int cur = 0, count = 0;
        for (int b : bloomDay) {
            if (days >= b) {
                cur++;
                if (cur >= k) {
                    count++;
                    cur = 0;
                }
            } else {
                cur = 0;
            }
        }
        return count >= m;
    }

}
