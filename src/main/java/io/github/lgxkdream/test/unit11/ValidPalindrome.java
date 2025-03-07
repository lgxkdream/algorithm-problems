package io.github.lgxkdream.test.unit11;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 125. 验证回文串
 * @description
 * @since 2020-06-19 12:45
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        /**
         * true
         */
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        /**
         * false
         */
        System.out.println(isPalindrome("race a car"));
        /**
         * true
         */
        System.out.println(isPalindrome(".,"));
        /**
         * false
         */
        System.out.println(isPalindrome("0P"));
        /**
         * false
         */
        System.out.println(isPalindrome("ab2a"));
    }

    public static boolean isPalindrome(String s) {
        if (s.length() < 2) {
            return true;
        }
        char[] chars = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(chars[i])) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(chars[j])) {
                j--;
            }
            // if (i < j && Math.abs(chars[i] - chars[j]) != 0 && !(chars[i] >= 'A' && chars[j] >= 'A' && Math.abs(chars[i] - chars[j]) == 32)) {
            //     return false;
            // }
            // i++;
            // j--;
            if (i < j && Character.toLowerCase(chars[i++]) != Character.toLowerCase(chars[j--])) {
                return false;
            }
        }
        return true;
    }

}
