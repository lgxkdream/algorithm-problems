package io.github.lgxkdream.test.unit9;

import java.util.stream.IntStream;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 面试题64. 求1+2+…+n
 * @description https://leetcode-cn.com/problems/qiu-12n-lcof/
 * @since 2020-06-02 10:06
 */
public class Qiu12nLcof {

    /**
     * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     *
     * @param args
     */
    public static void main(String[] args) {
        // 输出: 6
        System.out.println(sumNums1(3));
        // 输出: 45
        System.out.println(sumNums(9));
    }

    /**
     * 逻辑运算符的短路性质
     *
     * @param n
     * @return
     */
    public static int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    /**
     * 数组越界异常检测
     *
     * @param n
     * @return
     */
    public static int sumNums1(int n) {
        int[] arr = new int[1];
        try {
            return arr[n];
        } catch (Exception e) {
            return n + sumNums1(n - 1);
        }
    }

    /**
     * jdk8 stream
     *
     * @param n
     * @return
     */
    public static int sumNums2(int n) {
        return IntStream.range(1, n + 1).sum();
    }

}
