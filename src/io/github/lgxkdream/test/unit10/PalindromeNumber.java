package io.github.lgxkdream.test.unit10;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 9. 回文数
 * @description https://leetcode-cn.com/problems/palindrome-number/
 * @since 2020-06-10 13:08
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(1221);
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return x == reverse || x == reverse / 10;
    }

}
