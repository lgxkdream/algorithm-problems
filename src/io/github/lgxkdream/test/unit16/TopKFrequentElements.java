package io.github.lgxkdream.test.unit16;

import java.util.Arrays;
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
        System.out.println(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
        /**
         * 输出: [1]
         */
        System.out.println(topKFrequent(new int[]{1}, 1));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Arrays.stream(nums).boxed().collect(Collectors.toMap(n -> n, n -> 1, Integer::sum));
        return null;
    }

}
