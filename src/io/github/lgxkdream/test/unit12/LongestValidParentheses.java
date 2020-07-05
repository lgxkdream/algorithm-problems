package io.github.lgxkdream.test.unit12;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 32. 最长有效括号
 * @description https://leetcode-cn.com/problems/longest-valid-parentheses/
 * @since 2020-07-04 09:44
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        /**
         * 输出: 2
         * 解释: 最长有效括号子串为 "()"
         */
        System.out.println(longestValidParentheses("(()"));
        /**
         * 输出: 4
         * 解释: 最长有效括号子串为 "()()"
         */
        System.out.println(longestValidParentheses(")()())"));
        /**
         * 输出: 2
         */
        System.out.println(longestValidParentheses("()(()"));
        /**
         * 输出: 6
         */
        System.out.println(longestValidParentheses("()(())"));
    }

    public static int longestValidParentheses(String s) {
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    // 设置下一个长度的起始位置
                    stack.push(i);
                } else {
                    // 求最大长度
                    result = Math.max(result, i - stack.peek());
                }
            }
        }
        return result;
    }

}
