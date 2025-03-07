package io.github.lgxkdream.test.unit1;

import java.util.Arrays;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title FindContentChildren
 * @description
 * @since 2020-03-16 15:04
 */
public class FindContentChildren {

    public static void main(String[] args) {
        // int[] g = {1,2,3}, s = {1,1};
        int[] g = {1, 2}, s = {1, 2, 3};
        System.out.println(findContentChildren(g, s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gIndex = 0;
        int sIndex = 0;
        while (gIndex < g.length && sIndex < s.length) {
            if (g[gIndex] <= s[sIndex]) {
                gIndex++;
            }
            sIndex++;
        }
        return gIndex;
    }

}
