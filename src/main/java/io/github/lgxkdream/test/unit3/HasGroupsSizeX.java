package io.github.lgxkdream.test.unit3;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title HasGroupsSizeX
 * @description https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/
 * @since 2020-03-27 09:33
 */
public class HasGroupsSizeX {

    public static void main(String[] args) {
        // int[] deck = {1, 2, 3, 4, 4, 3, 2, 1};
        // int[] deck = {1, 1, 1, 2, 2, 2, 3, 3};
        int[] deck = {1, 1};
        System.out.println(hasGroupsSizeX(deck));

        // System.out.println(gcd(319, 377));
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static boolean hasGroupsSizeX(int[] deck) {
        int[] num = new int[10000];
        for (int d : deck) {
            num[d]++;
        }
        int gcd = 0;
        for (int n : num) {
            if (n > 0) {
                if (gcd == 0) {
                    gcd = n;
                } else {
                    gcd = gcd(gcd, n);
                }
                if (gcd < 2) {
                    return false;
                }
            }
        }
        return true;
    }

}
