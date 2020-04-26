package io.github.lgxkdream.test.unit1;

import java.util.Arrays;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title MergeArr
 * @description
 * @since 2020-03-17 22:41
 */
public class MergeArr {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 0, 0, 0}, B = {2, 5, 6};
        int m = 3, n = 3;
        merge1(A, m, B, n);
        Arrays.stream(A).forEach(System.out::println);
    }

    public static void merge(int[] A, int m, int[] B, int n) {
        int index = m + n - 1;
        while (m > 0 && n > 0) {
            if (A[m-1] > B[n-1]) {
                A[index--] = A[--m];
            } else {
                A[index--] = B[--n];
            }
        }
        while (n > 0) {
            A[index--] = B[--n];
        }
    }

    public static void merge1(int[] A, int m, int[] B, int n) {
        int index = m + n - 1;
        while (n > 0) {
            A[index--] = B[--n];
        }
        Arrays.sort(A);
    }

}
