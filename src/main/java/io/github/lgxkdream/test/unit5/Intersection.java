package io.github.lgxkdream.test.unit5;

import java.util.Arrays;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title Intersection
 * @description https://leetcode-cn.com/problems/intersection-lcci/
 * @since 2020-04-12 09:00
 */
public class Intersection {

    public static void main(String[] args) {
        int[] start1 = {0, 0}, end1 = {1, 0}, start2 = {1, 1}, end2 = {0, -1}; // {0.5, 0}
        // int[] start1 = {0, 0}, end1 = {3, 3}, start2 = {1, 1}, end2 = {2, 2}; // {1, 1}
        // int[] start1 = {0, 0}, end1 = {1, 1}, start2 = {1, 0}, end2 = {2, 1} // {}
        System.out.println(Arrays.toString(intersection(start1, end1, start2, end2)));
    }

    public static double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        return null;
    }

}
