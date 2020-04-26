package io.github.lgxkdream.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title Test5
 * @description
 * @since 2020-04-11 11:59
 */
public class Test5 {

    public static void main(String[] args) {
        int[] array1 = {1,4,6};
        int[] array2 = {2,4,6};
        int[] ints = retainAll(array1, array2);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] retainAll(int[] array1, int[] array2) {
        if (array1.length < 1 || array2.length < 1) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] == array2[j]) {
                list.add(array1[i]);
                i++;
                j++;
            } else if (array1[i] > array2[j]) {
                j++;
            } else {
                i++;
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

}
