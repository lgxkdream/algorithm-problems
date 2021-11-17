package io.github.lgxkdream.unit9;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 面试题 17.14. 最小K个数
 * @description https://leetcode-cn.com/problems/smallest-k-lcci/
 * @since 9/3/21 9:09 PM
 */
public class SmallestK {

    public static void main(String[] args) {
        /**
         * 输出： [1,2,3,4]
         */
        System.out.println(Arrays.toString(smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4)));
    }

    public static int[] smallestK(int[] arr, int k) {
        int[] res = new int[k];
        if (k == 0) {
            return res;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < queue.peek()) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

}
