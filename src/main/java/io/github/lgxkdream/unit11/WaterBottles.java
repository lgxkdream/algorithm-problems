package io.github.lgxkdream.unit11;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 1518. 换酒问题
 * @description https://leetcode-cn.com/problems/water-bottles/
 * @since 12/17/21 9:44 PM
 */
public class WaterBottles {

    public static void main(String[] args) {
        /**
         * 输出：13
         * 解释：你可以用 3 个空酒瓶兑换 1 瓶酒。
         * 所以最多能喝到 9 + 3 + 1 = 13 瓶酒。
         */
        System.out.println(numWaterBottles(9, 3));
        /**
         * 输出：19
         * 解释：你可以用 4 个空酒瓶兑换 1 瓶酒。
         * 所以最多能喝到 15 + 3 + 1 = 19 瓶酒。
         */
        System.out.println(numWaterBottles(15, 4));
        /**
         * 输出：6
         */
        System.out.println(numWaterBottles(5, 5));
        /**
         * 输出：2
         */
        System.out.println(numWaterBottles(2, 3));
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        int numEmptyBottles = numBottles;
        while (numEmptyBottles / numExchange > 0) {
            res += numEmptyBottles / numExchange;
            numEmptyBottles = numEmptyBottles / numExchange + numEmptyBottles % numExchange;
        }
        return res;
    }

}
