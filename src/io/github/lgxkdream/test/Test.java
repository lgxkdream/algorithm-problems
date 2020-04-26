package io.github.lgxkdream.test;

import java.util.Arrays;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title Test
 * @description
 * @since 2020-03-20 13:58
 */
public class Test {

    public static void main(String[] args) {
        int[] arr = {23, 45, 56, 78};
        int num = 79;
        int[] test = test(arr, num);
        if (test != null) {
            Arrays.stream(test).forEach(System.out::println);
        }
    }

    private static int[] test(int[] arr, int num) {
        for (int j = 0; j < arr.length - 1; j++) {
            int a = arr[j];
            for (int i = j + 1; i < arr.length; i++) {
                if (a + arr[i] == num) {
                    int[] result = new int[2];
                    result[0] = j;
                    result[1] = i;
                    return result;
                }
            }
        }
        return null;
    }

}
