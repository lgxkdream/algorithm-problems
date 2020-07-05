package io.github.lgxkdream.test.unit12;

import java.util.PriorityQueue;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 215. 数组中的第K个最大元素
 * @description https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * @since 2020-06-29 10:11
 */
public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        /**
         * 输出: 5
         */
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        /**
         * 输出: 4
         */
        System.out.println(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    /**
     * 小根堆思想
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

}
