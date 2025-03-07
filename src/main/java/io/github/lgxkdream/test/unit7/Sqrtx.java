package io.github.lgxkdream.test.unit7;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title x 的平方根
 * @description https://leetcode-cn.com/problems/sqrtx/
 * @since 2020-05-09 09:57
 */
public class Sqrtx {

    public static void main(String[] args) {
        System.out.println(mySqrt(4)); // 2
        System.out.println(mySqrt(2147395599)); // 2
        System.out.println(mySqrt1(10));
    }

    /**
     * 效率低
     *
     * @param x
     * @return
     */
    public static int mySqrt1(int x) {
        int left = 0, right = x;
        int mid = x;
        while (left <= right) {
            mid = left + (right - left) / 2;
            long midSquare = mid * mid;
            long midAddSquare = (mid + 1) * (mid + 1);
            if (midSquare > x) {
                right = mid;
            } else if (midAddSquare <= x) {
                left = mid;
            } else {
                break;
            }
        }
        return mid;
    }

    /**
     * 高效率
     *
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        int left = 0, right = x, result = -1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if ((long) mid * mid <= x) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

}
