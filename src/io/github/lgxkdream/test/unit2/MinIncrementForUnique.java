package io.github.lgxkdream.test.unit2;

import java.util.Arrays;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title MinIncrementForUnique
 * @description
 * @since 2020-03-22 11:14
 */
public class MinIncrementForUnique {

    public static void main(String[] args) {
        // int[] arr = {3, 2, 1, 2, 1, 7};
        int[] arr = {1, 2, 2};
        System.out.println(minIncrementForUnique(arr));
    }

    public static int minIncrementForUnique(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        Arrays.sort(A);
        int result = 0;
        int begin = A[0];
        for (int i : A) {
            if (begin >= i) {
                result += (begin++ - i);
            } else {
                begin = i + 1;
            }
        }
        return result;
    }

}
