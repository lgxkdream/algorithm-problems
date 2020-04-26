package io.github.lgxkdream.test.unit4;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title MyAtoi
 * @description https://leetcode-cn.com/problems/string-to-integer-atoi/
 * @since 2020-04-03 09:40
 */
public class MyAtoi {

    public static void main(String[] args) {
        System.out.println(myAtoi("42")); // 42
        System.out.println(myAtoi("   -42")); // -42
        System.out.println(myAtoi("4193 with words")); // 4193
        System.out.println(myAtoi("words and 987")); // 0
        System.out.println(myAtoi("-91283472332")); // -2147483648
    }

    public static int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int length = str.length();
        int i = 0;
        while (i < length && chars[i] == ' ') {
            i++;
        }
        if (i == length) {
            return 0;
        }
        boolean nagetive = false;
        if (chars[i] == '+') {
            i++;
        } else if (chars[i] == '-') {
            nagetive = true;
            i++;
        } else if (chars[i] < '0' || chars[i] > '9') {
            return 0;
        }
        int result = 0;
        while (i < length && chars[i] >= '0' && chars[i] <= '9') {
            int digist = chars[i] - '0';
            if (result > (Integer.MAX_VALUE - digist) / 10) {
                return nagetive ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + digist;
            i++;
        }
        return nagetive ? -result : result;
    }

}
