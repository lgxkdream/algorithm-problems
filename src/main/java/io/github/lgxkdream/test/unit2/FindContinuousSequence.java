package io.github.lgxkdream.test.unit2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title FindContinuousSequence
 * @description
 * @since 2020-03-21 19:40
 */
public class FindContinuousSequence {

    public static void main(String[] args) {
        int target = 9;
        Arrays.stream(findContinuousSequence(target)).forEach(arr -> Arrays.stream(arr).forEach(System.out::println));
        // 输出：[[2,3,4],[4,5]]
    }

    public static int[][] findContinuousSequence(int target) {
        List<int[]> result = new ArrayList<>();
        for (int i = 1; i < (target / 2) + 1; i++) {
            int count = 0;
            int j = i;
            while (count < target) {
                count = count + j;
                j ++;
            }
            if (count == target) {
                int[] arr = new int[j - i];
                for (int k = 0; k < j - i; k++) {
                    arr[k] = i + k;
                }
                result.add(arr);
            }

        }
        return result.stream().toArray(int[][]::new);
    }

}
