package io.github.lgxkdream.unit3;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 最低票价
 * @description https://leetcode-cn.com/problems/minimum-cost-for-tickets/
 * @since 2020-05-06 10:04
 */
public class MinimumCostForTickets {

    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15}; // 1/7/30
        System.out.println(mincostTickets(days, costs)); // 11
        int[] days1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        int[] costs1 = {2, 7, 15};
        System.out.println(mincostTickets(days1, costs1)); // 17
    }

    /**
     * 动态规划
     *
     * @param days
     * @param costs
     * @return
     */
    public static int mincostTickets(int[] days, int[] costs) {
        int len = days.length, maxDay = days[len - 1], minDay = days[0];
        // 之所以+31是因为如果最大天数为n时，dp[n] = min(dp[n+1] + costs[0], dp[n+7] + costs[1], dp[n+30] + costs[2]), 想要数组有 dp[n+30] 这项，则数组最小为 n + 31
        int[] dp = new int[maxDay + 31];
        // 只需看 maxDay -> minDay，此区间外都不需要出门，不会增加费用
        for (int d = maxDay, i = len - 1; d >= minDay; d--) {
            // i 表示 days 的索引
            // 也可提前将所有 days 放入 Set，再通过 set.contains() 判断
            if (d == days[i]) {
                dp[d] = Math.min(dp[d + 1] + costs[0], dp[d + 7] + costs[1]);
                dp[d] = Math.min(dp[d], dp[d + 30] + costs[2]);
                // 别忘了递减一天
                i--;
            } else {
                // 不需要出门
                dp[d] = dp[d + 1];
            }
        }
        return dp[minDay]; // 从后向前遍历，返回最前的 minDay
    }

}
