package io.github.lgxkdream.test.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title Test9
 * @description
 * @since 2020-01-21 12:14
 */
public class Test9 {

    public static void main(String[] args) {
        // int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices = {7, 6, 4, 3, 1};
        // System.out.println(maxProfit1(prices));

        // int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices1 = {1, 2, 3, 4, 5};
        // int[] prices1 = {7, 6, 4, 3, 1};
        // System.out.println(maxProfit2(prices1));

        // int[] prices3 = {3, 3, 5, 0, 0, 3, 1, 4};
        // int[] prices3 = {1, 2, 3, 4, 5};
        // int[] prices3 = {7, 6, 4, 3, 1};
        // int[] prices3 = {};
        int[] prices3 = {1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
        // System.out.println(maxProfit3(prices3));
        // System.out.println(maxProfit4(prices3));
        // System.out.println(maxProfit5(prices3));
        System.out.println(maxProfit6(prices3)); // 13
    }

    public static int maxProfit6(int[] prices) {
        int a = 0, b = Integer.MIN_VALUE, c = 0, d = Integer.MIN_VALUE;
        for (int price : prices) {
            a = Math.max(a, b + price);
            b = Math.max(b, c - price);
            c = Math.max(c, d + price);
            d = Math.max(d, -price);
        }
        return a;
    }

    public static int maxProfit5(int[] prices) {
        /**
         //fst的两个变量的意义与121题相同，就是简单的动态规划更新

         fstMineprice : 到该天为止第一次买入股票的最小价格（即所有股票价格的最小值）
         fstMaxprofit: 到该天为止第一次卖出股票的最大收益（即只交易一次的最大收益）

         //sec的两个变量的意义要注意，特别是secMinprice，不单纯是股票原价格，而是在此基础上减去第一次收益

         secMinprice: 到该天为止第二次买入股票的最小价格（第二次买入股票的价格是原股票价格减去第一次买卖收益）
         secMaxprofit: 到该天为止第二次卖出股票可获得的最大收益

         分别对四个变量进行相应的更新, 最后secMaxprofit就是最大
         **/
        int fstMineprice = Integer.MAX_VALUE, fstMaxprofit = 0;
        int secMinprice = Integer.MAX_VALUE, secMaxprofit = 0;
        for(int p : prices) {
            //更新fstMineprice与fstMaxprofit，这里应该没有问题，与121题一样
            fstMineprice = Math.min(fstMineprice, p); // 1
            fstMaxprofit = Math.max(fstMaxprofit, p-fstMineprice); // 8

            //更新secMineprice与secMaxprofit
            secMinprice = Math.min(secMinprice, p-fstMaxprofit);//加入的p产生的最小价格就是p减去第一次买卖的最大收益，以此更新secMinprice
            secMaxprofit = Math.max(secMaxprofit, p-secMinprice);//p产生的最大收益就是p减去第二次买入的最小价格secMinprice，以此更新secMaxprofit
        }
        return secMaxprofit;
    }

    public static int maxProfit4(int[] prices) {
        /**
         对于任意一天考虑四个变量:
         fstBuy: 在该天第一次买入股票可获得的最大收益
         fstSell: 在该天第一次卖出股票可获得的最大收益
         secBuy: 在该天第二次买入股票可获得的最大收益
         secSell: 在该天第二次卖出股票可获得的最大收益
         分别对四个变量进行相应的更新, 最后secSell就是最大
         收益值(secSell >= fstSell)
         **/
        int fstBuy = Integer.MIN_VALUE, fstSell = 0;
        int secBuy = Integer.MIN_VALUE, secSell = 0;
        for(int p : prices) {
            fstBuy = Math.max(fstBuy, -p);
            fstSell = Math.max(fstSell, fstBuy + p);
            secBuy = Math.max(secBuy, fstSell - p);
            secSell = Math.max(secSell, secBuy + p);
        }
        return secSell;
    }

    /**
     //fst的两个变量的意义与121题相同，就是简单的动态规划更新

     fstMineprice : 到该天为止第一次买入股票的最小价格（即所有股票价格的最小值）
     fstMaxprofit: 到该天为止第一次卖出股票的最大收益（即只交易一次的最大收益）

     //sec的两个变量的意义要注意，特别是secMinprice，不单纯是股票原价格，而是在此基础上减去第一次收益

     secMinprice: 到该天为止第二次买入股票的最小价格（第二次买入股票的价格是原股票价格减去第一次买卖收益）
     secMaxprofit: 到该天为止第二次卖出股票可获得的最大收益

     分别对四个变量进行相应的更新, 最后secMaxprofit就是最大
     **/

    public static int maxProfit3(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        List<Integer> maxProfits = new ArrayList<>();
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += (prices[i] - prices[i - 1]);
                if (i == prices.length - 1) {
                    maxProfits.add(maxProfit);
                }
            } else {
                maxProfits.add(maxProfit);
                maxProfit = 0;
            }
        }
        Collections.sort(maxProfits, (a, b) -> b - a);
        if (maxProfits.size() < 2) {
            return maxProfits.get(0);
        }
        return maxProfits.get(0) + maxProfits.get(1);
    }


    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }

    public static int maxProfit1(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int min = prices[0], maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - min);
        }
        return maxProfit;
    }

    public static int maxProfit2(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += (prices[i] - prices[i - 1]);
            }
        }
        return maxProfit;
    }

}
