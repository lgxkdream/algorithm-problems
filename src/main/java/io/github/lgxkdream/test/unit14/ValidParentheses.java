package io.github.lgxkdream.test.unit14;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 20. 有效的括号
 * @description https://leetcode-cn.com/problems/valid-parentheses/
 * @since 2020-08-14 09:55
 */
public class ValidParentheses {

    public static void main(String[] args) {
        /**
         * 输出: true
         */
        System.out.println(isValid("()"));
        /**
         * 输出: true
         */
        System.out.println(isValid("()[]{}"));
        /**
         * 输出: false
         */
        System.out.println(isValid("(]"));
        /**
         * 输出: false
         */
        System.out.println(isValid("([)]"));
        /**
         * 输出: true
         */
        System.out.println(isValid("{[]}"));
    }

    public static boolean isValid(String s) {
        if (s == null || s.equals("")) {
            return true;
        }
        Map<Character, Character> bracketsMap = new HashMap<>();
        bracketsMap.put(')', '(');
        bracketsMap.put('}', '{');
        bracketsMap.put(']', '[');
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (bracketsMap.containsKey(aChar)) {
                if (stack.isEmpty() || bracketsMap.get(aChar) != stack.peek()) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(aChar);
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid1(String s) {
        if (s == null || s.equals("")) {
            return true;
        }
        char[] chars = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        int index = 0;
        stack.push(chars[index++]);
        while (index < chars.length) {
            char aChar = chars[index++];
            Character peek = stack.peek();
            if (peek == null) {
                stack.push(aChar);
            } else {
                if (peek == '(' && aChar == ')') {
                    stack.pop();
                } else if (peek == '{' && aChar == '}') {
                    stack.pop();
                } else if (peek == '[' && aChar == ']') {
                    stack.pop();
                } else {
                    stack.push(aChar);
                }
            }
        }
        return stack.isEmpty();
    }

}
