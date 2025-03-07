package io.github.lgxkdream.test.unit4;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title ReverseWords
 * @description https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * @since 2020-04-10 10:11
 */
public class ReverseWords {

    public static void main(String[] args) {
        String s = "  hello  world!  ";
        // String s = "    ";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r && s.charAt(l) == ' ') {
            l++;
        }
        while (l <= r && s.charAt(r) == ' ') {
            r--;
        }
        Deque<String> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        while (l <= r) {
            if (s.charAt(l) == ' ' && sb.length() != 0) {
                deque.offerFirst(sb.toString());
                sb.setLength(0);
            } else if (s.charAt(l) != ' ') {
                sb.append(s.charAt(l));
            }
            l++;
        }
        deque.addFirst(sb.toString());
        return String.join(" ", deque);
    }

}
