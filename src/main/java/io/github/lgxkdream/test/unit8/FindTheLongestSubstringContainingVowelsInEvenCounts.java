package io.github.lgxkdream.test.unit8;

import java.util.Arrays;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 每个元音包含偶数次的最长子字符串
 * @description https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/
 * @since 2020-05-20 10:15
 */
public class FindTheLongestSubstringContainingVowelsInEvenCounts {

    public static void main(String[] args) {
        /**
         * 输出：13
         * 解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
         */
        System.out.println(findTheLongestSubstring("eleetminicoworoep"));

        /**
         * 输出：5
         * 解释：最长子字符串是 "leetc" ，其中包含 2 个 e 。
         */
        System.out.println(findTheLongestSubstring("leetcodeisgreat"));

        /**
         * 输出：6
         * 解释：这个示例中，字符串 "bcbcbc" 本身就是最长的，因为所有的元音 a，e，i，o，u 都出现了 0 次。
         */
        System.out.println(findTheLongestSubstring("bcbcbc"));
    }

    public static int findTheLongestSubstring(String s) {
        // 用一个长度为 32 的数组来存储对应状态出现的最早位置
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        int ans = 0, status = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                status ^= (1 << 0);
            } else if (ch == 'e') {
                status ^= (1 << 1);
            } else if (ch == 'i') {
                status ^= (1 << 2);
            } else if (ch == 'o') {
                status ^= (1 << 3);
            } else if (ch == 'u') {
                status ^= (1 << 4);
            }
            // 得到当前各元音的奇偶状态
            if (status == 0) {
                // 如果都为偶状态
                ans = Math.max(ans, i + 1);
            } else if (pos[status] >= 0) {
                // 如果该奇偶状态出现过
                ans = Math.max(ans, i - pos[status]);
            } else {
                // 如果没出现过记录出现的最早位置
                pos[status] = i;
            }
        }
        return ans;
    }

}
