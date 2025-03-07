package io.github.lgxkdream.unit9;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 787. K 站中转内最便宜的航班
 * @description https://leetcode-cn.com/problems/cheapest-flights-within-k-stops/
 * @since 2021-08-24 21:08
 */
public class FindCheapestPrice {

    public static void main(String[] args) {
        /**
         * 输出: 200
         */
        System.out.println(findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1));
        /**
         * 输出: 500
         */
        System.out.println(findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 0));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        return 0;
    }

}
