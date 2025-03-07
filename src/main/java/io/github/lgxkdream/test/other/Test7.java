package io.github.lgxkdream.test.other;

/**
 * @author LiGang
 * @version 1.0.0
 * @title Test7
 * @description
 * @since 2020-01-17 15:01
 */
public class Test7 {

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
        s = "axc";
        t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    private static boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

}
