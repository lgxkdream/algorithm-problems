package io.github.lgxkdream.test.unit5;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title CountTheRepetitions
 * @description https://leetcode-cn.com/problems/count-the-repetitions/
 * @since 2020-04-19 10:28
 */
public class CountTheRepetitions {

    public static void main(String[] args) {
        String s1 = "acb", s2 = "ab";
        int n1 = 4, n2 = 2;
        System.out.println(getMaxRepetitions(s1, n1, s2, n2));
    }

    // acb acb acb acb
    // ab ab
    public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0) {
            return 0;
        }

        int s1cnt = 0, index = 0, s2cnt = 0;

        // 记录在每个s1末尾，最后在s2中出现的index值，
        List<Integer> indexs = new LinkedList<>();
        // hash表，与上面的 indexs 一起组成官方题解中的 recall
        int[] s1cnts = new int[s2.length()];
        int[] s2cnts = new int[s2.length()];

        int[] pre_loop = new int[2];
        int[] in_loop = new int[2];

        while (true) {
            s1cnt += 1;
            for (char ch : s1.toCharArray()) {
                if (ch == s2.charAt(index)) {
                    index += 1;
                    // 找到一个完整的s2，将s2cnt+1并重置index
                    if (index == s2.length()) {
                        s2cnt += 1;
                        index = 0;
                    }
                }
            }
            // 还没有找到循环节，所有的 s1 就用完了
            if (s1cnt == n1) {
                return s2cnt / n2;
            }
            // 出现了之前的 index，表示找到了循环节
            if (indexs.contains(index)) {
                int s1cnt_prime = s1cnts[index];
                int s2cnt_prime = s2cnts[index];
                // 前 s1cnt' 个 s1 包含了 s2cnt' 个 s2
                pre_loop[0] = s1cnt_prime;
                pre_loop[1] = s2cnt_prime;
                // 以后的每 (s1cnt - s1cnt') 个 s1 包含了 (s2cnt - s2cnt') 个 s2
                in_loop[0] = s1cnt - s1cnt_prime;
                in_loop[1] = s2cnt - s2cnt_prime;
                break;
            } else {
                indexs.add(index);
                s1cnts[index] = s1cnt;
                s2cnts[index] = s2cnt;
            }
        }

        // ans 存储的是 S1 包含的 s2 的数量，考虑的之前的 pre_loop 和 in_loop
        int ans = pre_loop[1] + (n1 - pre_loop[0]) / in_loop[0] * in_loop[1];
        // S1 的末尾还剩下一些 s1，我们暴力进行匹配
        int rest = (n1 - pre_loop[0]) % in_loop[0];
        for (int i = 0; i < rest; i++) {
            for (char ch : s1.toCharArray()) {
                if (ch == s2.charAt(index)) {
                    index += 1;
                    if (index == s2.length()) {
                        ans += 1;
                        index = 0;
                    }
                }
            }
        }
        // S1 包含 ans 个 s2，那么就包含 ans / n2 个 S2
        return ans / n2;
    }


}
