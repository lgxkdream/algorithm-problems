package io.github.lgxkdream.unit9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 502. IPO
 * @description https://leetcode-cn.com/problems/ipo/
 * @since 9/8/21 11:16 PM
 */
public class Ipo {

    public static void main(String[] args) {
        /**
         * 输入：k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
         * 输出：4
         * 解释：
         * 由于你的初始资本为 0，你仅可以从 0 号项目开始。
         * 在完成后，你将获得 1 的利润，你的总资本将变为 1。
         * 此时你可以选择开始 1 号或 2 号项目。
         * 由于你最多可以选择两个项目，所以你需要完成 2 号项目以获得最大的资本。
         * 因此，输出最后最大化的资本，为 0 + 1 + 3 = 4。
         */
        System.out.println(findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}));
        /**
         * 输出：6
         */
        System.out.println(findMaximizedCapital(3, 0, new int[]{1, 2, 3}, new int[]{0, 1, 2}));
        System.out.println(findMaximizedCapital(1, 1, new int[]{2, 3}, new int[]{1, 1}));
    }

    /**
     * 大根堆+贪心
     */
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int len = profits.length;
        int[][] arr = new int[len][2];
        for (int i = 0; i < len; i++) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int cur = 0;
        for (int i = 0; i < k; i++) {
            while (cur < len && w >= arr[cur][0]) {
                queue.offer(arr[cur][1]);
                cur++;
            }
            if (queue.isEmpty()) {
                break;
            } else {
                w += queue.poll();
            }
        }
        return w;
    }

}
