package io.github.lgxkdream.test.unit4;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title MinDistance
 * @description https://leetcode-cn.com/problems/edit-distance/
 * @since 2020-04-06 11:03
 */
public class MinDistance {

    public static void main(String[] args) {
        // String word1 = "horse", word2 = "ros"; // 3
        // String word1 = "intention", word2 = "execution"; // 5
        String word1 = "dinitrazine", word2 = "benzrazone";
        System.out.println(minDistance(word1, word2));
    }

    public static int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        } else if (word2.length() == 0) {
            return word1.length();
        }
        int leftDown = minDistance(word1.substring(0, word1.length() - 1), word2.substring(0, word2.length() - 1));
        if (word1.charAt(word1.length() - 1) == word2.charAt(word2.length() - 1)) {
            return leftDown;
        }
        int left = minDistance(word1.substring(0, word1.length() - 1), word2) + 1;
        int down = minDistance(word1, word2.substring(0, word2.length() - 1)) + 1;
        leftDown++;
        return Math.min(leftDown, Math.min(left, down));
    }

    /**
     * 最后一位不一样
     * dp(i, j) = 1 + min(dp(i-1, j),dp(i, j-1),dp(i-1, j-1))
     * 最后一位一样
     * dp(i, j) = 1 + min(dp(i-1, j),dp(i, j-1),dp(i-1, j-1) - 1);
     *
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance1(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        if (length1 * length2 == 0) {
            return length1 + length2;
        }
        // dp[a][b]代表把word1的前a个字符转换成word2的前b个字符所需要的最少操作次数
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 1; i < length1 + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j < length2 + 1; j++) {
            dp[0][j] = j;
        }
        // i,j代表的是第几个字母
        for (int i = 1; i < length1 + 1; i++) {
            for (int j = 1; j < length2 + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int leftDown = dp[i - 1][j - 1] + 1;
                dp[i][j] = Math.min(left, Math.min(down, leftDown));
            }
        }
        return dp[length1][length2];
    }

}
