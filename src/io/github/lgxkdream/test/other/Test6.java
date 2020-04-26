package io.github.lgxkdream.test.other;

/**
 * @author LiGang
 * @version 1.0.0
 * @title Test6
 * @description
 * @since 2020-01-17 14:16
 */
public class Test6 {

    private static int[] F = new int[1000];

    public static void main(String[] args) {
        int N = 30;
        F[0] = 0;
        F[1] = 1;
        for (int i = 2; i <= N; i++) {
            F[i] = F[i - 1] + F[i - 2];
        }
        System.out.println(F[N]);
    }

}
