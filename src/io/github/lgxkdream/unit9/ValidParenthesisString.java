package io.github.lgxkdream.unit9;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 678. 有效的括号字符串
 * @description https://leetcode-cn.com/problems/valid-parenthesis-string/
 * @since 9/12/21 10:32 PM
 */
public class ValidParenthesisString {

    public static void main(String[] args) {
        /**
         * 输出: True
         */
        System.out.println(checkValidString("()"));
        /**
         * 输出: True
         */
        System.out.println(checkValidString("(*)"));
        /**
         * 输出: True
         */
        System.out.println(checkValidString("(*))"));
        /**
         * 输出: False
         */
        System.out.println(checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
    }

    public static boolean checkValidString(String s) {
        Deque<Integer> leftStack = new LinkedList<>();
        Deque<Integer> asteriskStack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftStack.push(i);
            } else if (c == '*') {
                asteriskStack.push(i);
            } else {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!asteriskStack.isEmpty()) {
                    asteriskStack.pop();
                } else {
                    return false;
                }
            }
        }
        while (!leftStack.isEmpty() && !asteriskStack.isEmpty()) {
            Integer left = leftStack.pop();
            Integer asterisk = asteriskStack.pop();
            if (left > asterisk) {
                return false;
            }
        }
        return leftStack.isEmpty();
    }

}
