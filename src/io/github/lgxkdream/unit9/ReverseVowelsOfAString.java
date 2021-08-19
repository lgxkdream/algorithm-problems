package io.github.lgxkdream.unit9;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 345. 反转字符串中的元音字母
 * @description https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
 * @since 2021-08-19 21:21
 */
public class ReverseVowelsOfAString {

    public static void main(String[] args) {
        /**
         * 输出："holle"
         */
        System.out.println(reverseVowels("hello"));
        /**
         * 输出："leotcede"
         */
        System.out.println(reverseVowels("leetcode"));
        /**
         * 输出：".,"
         */
        System.out.println(reverseVowels(".,"));
    }

    public static String reverseVowels(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int left = 0, right = len - 1;
        while (left < right) {
            while (left < len && !isVowels(chars[left])) {
                left++;
            }
            while (right >= 0 && !isVowels(chars[right])) {
                right--;
            }
            if (left >= right) {
                break;
            }
            swap(chars, left, right);
            left++;
            right--;
        }
        return new String(chars);
    }

    private static boolean isVowels(int ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

}
