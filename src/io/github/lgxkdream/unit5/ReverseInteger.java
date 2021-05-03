package io.github.lgxkdream.unit5;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 7. 整数反转
 * @description https://leetcode-cn.com/problems/reverse-integer/
 * @since 5/3/21 7:12 PM
 */
public class ReverseInteger {

    public static void main(String[] args) {
        /**
         * 输出：321
         */
        System.out.println(reverse(123));
        /**
         * 输出：-321
         */
        System.out.println(reverse(-123));
        /**
         * 输出：21
         */
        System.out.println(reverse(120));
        /**
         * 输出：0
         */
        System.out.println(reverse(0));
    }

    public static int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return (int) res == res ? (int) res : 0;
    }

}
