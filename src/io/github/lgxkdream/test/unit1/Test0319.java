package io.github.lgxkdream.test.unit1;

import java.util.HashMap;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title Test0319
 * @description
 * @since 2020-03-19 11:08
 */
public class Test0319 {

    static int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>(78);
        map.put(1, 2);
        System.out.println(tableSizeFor(17));
    }

    private static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

}
