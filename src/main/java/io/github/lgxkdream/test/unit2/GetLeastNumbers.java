package io.github.lgxkdream.test.unit2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title GetLeastNumbers
 * @description
 * @since 2020-03-20 09:58
 */
public class GetLeastNumbers {

    public static void main(String[] args) {
        int[] arr = {3,2,1};
        int k = 2;
        int[] leastNumbers = getLeastNumbers(arr, k);
        Arrays.stream(leastNumbers).forEach(System.out::println);
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int c = 0;
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            if (c < k) {
                list.add(i);
            } else {
                break;
            }
            c ++;
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

}
