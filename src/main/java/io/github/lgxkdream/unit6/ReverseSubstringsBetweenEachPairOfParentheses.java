package io.github.lgxkdream.unit6;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 1190. 反转每对括号间的子串
 * @description https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 * @since 2021-05-26 20:30
 */
public class ReverseSubstringsBetweenEachPairOfParentheses {

    public static void main(String[] args) {
        /**
         * 输出："dcba"
         */
        System.out.println(reverseParentheses("(abcd)"));
        /**
         * 输出："iloveu"
         */
        System.out.println(reverseParentheses("(u(love)i)"));
        /**
         * 输出："leetcode"
         */
        System.out.println(reverseParentheses("(ed(et(oc))el)"));
        /**
         * 输出："apmnolkjihgfedcbq"
         */
        System.out.println(reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }

    /**
     * 栈思想
     */
    public static String reverseParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else if (chars[i] == ')') {
                Integer pop = stack.pop();
                reverseStr(chars, pop + 1, i - 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            if (aChar == '(' || aChar == ')') {
                continue;
            }
            sb.append(aChar);
        }
        return sb.toString();
    }

    private static void reverseStr(char[] chars, Integer left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

}
