package io.github.lgxkdream.test.unit16;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 347. 前 K 个高频元素
 * @description https://leetcode-cn.com/problems/top-k-frequent-elements/
 * @since 2020-09-07 09:54
 */
public class TopKFrequentElements {

    public static void main(String[] args) {
        /**
         * 输出: [1,2]
         */
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        /**
         * 输出: [1]
         */
        System.out.println(Arrays.toString(topKFrequent(new int[]{1}, 1)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = Arrays.stream(nums).boxed().collect(Collectors.toMap(Function.identity(), n -> 1, Integer::sum));
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(countMap::get));
        countMap.forEach((num, count) -> {
            if (queue.size() < k) {
                queue.offer(num);
            } else if (count > countMap.get(queue.peek())) {
                queue.poll();
                queue.offer(num);
            }
        });
        int[] result = new int[queue.size()];
        int i = 0;
        for (Integer num : queue) {
            result[i++] = num;
        }
        return result;
    }

}
