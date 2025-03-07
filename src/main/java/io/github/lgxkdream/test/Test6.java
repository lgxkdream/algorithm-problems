package io.github.lgxkdream.test;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title
 * @description
 * @since 2020-04-26 21:29
 */
public class Test6 {

    public static void main(String[] args) {
        System.out.println(-20 >> 2);
        System.out.println(-20 >>> 2);
        System.out.println("=================");
        System.out.println(1<<2);
        System.out.println(1<<30);
        System.out.println(1 + (1<<2) + (1<<30));
        System.out.println("=================");
        System.out.println((1<<1) + (1<<29) + (1<<30));
        System.out.println("=================");
        System.out.println(Integer.MAX_VALUE + Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(-2 >>> 1);
        System.out.println("=================");
        // System.out.println(-2 >>> 1);
        // System.out.println(-1 >>> 1);
        // System.out.println(Integer.MAX_VALUE);
        // System.out.println(Integer.MAX_VALUE + 1);
        // System.out.println((Integer.MAX_VALUE + 1) >>> 1);
        // System.out.println((Integer.MAX_VALUE + 1) >> 1);
        // System.out.println("11111 11111 11111 11111 11111 11111 10");
        int x = 7;
        System.out.println(x & (-x));
        x = -12;
        System.out.println(x & (-x));
        char[] chars1 = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        char[] chars2 = {'a', 'c', 'd', 'e', 'f', 'g'};
        char c = find(chars1, chars2);
        System.out.println(c);
    }

    private static char find(char[] chars1, char[] chars2) {
        int low = 0;
        int high = chars1.length - 1;
        int middle = 0;
        while (low < high) {
            middle = (low + high) / 2;
            if (chars1[middle] == chars2[middle]) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return chars1[low];
    }

}
