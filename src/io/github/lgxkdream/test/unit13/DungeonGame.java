package io.github.lgxkdream.test.test13;

import java.util.Arrays;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 174. 地下城游戏
 * @description https://leetcode-cn.com/problems/dungeon-game/
 * @since 2020-07-12 22:09
 */
public class DungeonGame {

    public static void main(String[] args) {
        int[][] dp = new int[2][3];
        for (int i = 0; i <= 1; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        System.out.println(Arrays.deepToString(dp));
        System.out.println(calculateMinimumHP(new int[][]{
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        }));
    }

    /**
     * 动态规划思想
     * dp[i][j] =
     * @param dungeon
     * @return
     */
    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m][m];
        dp[0][0] = dungeon[0][0] >=0 ? 1 : 1 - dungeon[0][0];
        for (int i = 0; i < m; i++) {

        }
        for (int j = 0; j < n; j++) {

        }
        return 0;
    }

}
