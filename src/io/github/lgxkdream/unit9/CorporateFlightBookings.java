package io.github.lgxkdream.unit9;

import java.util.Arrays;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 1109. 航班预订统计
 * @description https://leetcode-cn.com/problems/corporate-flight-bookings/
 * @since 8/31/21 11:11 PM
 */
public class CorporateFlightBookings {

    public static void main(String[] args) {
        /**
         * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
         * 输出：[10,55,45,25,25]
         * 解释：
         * 航班编号        1   2   3   4   5
         * 预订记录 1 ：   10  10
         * 预订记录 2 ：       20  20
         * 预订记录 3 ：       25  25  25  25
         * 总座位数：      10  55  45  25  25
         * 因此，answer = [10,55,45,25,25]
         */
        System.out.println(Arrays.toString(corpFlightBookings(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5)));
        /**
         * 输出：[10,25]
         * 解释：
         * 航班编号        1   2
         * 预订记录 1 ：   10  10
         * 预订记录 2 ：       15
         * 总座位数：      10  25
         * 因此，answer = [10,25]
         */
        System.out.println(Arrays.toString(corpFlightBookings(new int[][]{{1, 2, 10}, {2, 2, 15}}, 2)));
    }

    /**
     * 差分
     *
     * @param bookings
     * @param n
     * @return
     */
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] booking : bookings) {
            res[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                res[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < res.length; i++) {
            res[i] += res[i - 1];
        }
        return res;
    }

}
