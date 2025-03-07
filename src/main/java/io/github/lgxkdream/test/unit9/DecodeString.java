package io.github.lgxkdream.test.unit9;

import java.util.Stack;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 字符串解码
 * @description https://leetcode-cn.com/problems/decode-string/
 * @since 2020-05-28 10:53
 */
public class DecodeString {

    public static void main(String[] args) {
        // 返回 aaabcbc
        System.out.println(decodeString("3[a]2[bc]"));
        // 返回 accaccacc
        System.out.println(decodeString("3[a2[c]]"));
        // 返回 abcabccdcdcdef
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }

    public static String decodeString(String s) {
        StringBuffer ans = new StringBuffer();
        // 数字栈
        Stack<Integer> multiStack = new Stack<>();
        // 字符串栈
        Stack<StringBuffer> ansStack = new Stack<>();
        int multi = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // 获取数字
                multi = multi * 10 + c - '0';
            } else if (c == '[') {
                ansStack.add(ans);
                multiStack.add(multi);
                ans = new StringBuffer();
                multi = 0;
            } else if (Character.isAlphabetic(c)) {
                ans.append(c);
            } else {
                StringBuffer ansTmp = ansStack.pop();
                int tmp = multiStack.pop();
                for (int i = 0; i < tmp; i++) {
                    ansTmp.append(ans);
                }
                ans = ansTmp;
            }
        }
        return ans.toString();
    }

}
