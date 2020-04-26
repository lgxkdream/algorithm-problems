package io.github.lgxkdream.test.unit5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title MergeIntervals
 * @description https://leetcode-cn.com/problems/merge-intervals/
 * @since 2020-04-16 09:56
 */
public class MergeIntervals {

    public static void main(String[] args) {
        // int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}}; // [[1,6],[8,10],[15,18]]
        int[][] intervals = {{1, 4}, {4, 5}}; // [[1,5]]
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(n -> n[0]));
        int[][] result = new int[intervals.length][2];
        int idx = 0;
        for (int[] interval : intervals) {
            if (idx == 0 || interval[0] > result[idx - 1][1]) {
                result[idx++] = interval;
            } else {
                result[idx - 1][1] = Math.max(result[idx - 1][1], interval[1]);
            }
        }
        int[][] copy = new int[idx][2];
        System.arraycopy(result, 0, copy, 0, idx);
        return copy;
    }


    public static int[][] merge2(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        // 遍历区间
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
            // 则不合并，直接将当前区间加入结果数组。
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                // 反之将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }

    public static int[][] merge1(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }
        Arrays.parallelSort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] < intervals[i + 1][0]) {
                list.add(intervals[i]);
                if (i == intervals.length - 2) {
                    list.add(intervals[i + 1]);
                }
            } else {
                intervals[i + 1] = new int[]{intervals[i][0], Math.max(intervals[i][1], intervals[i + 1][1])};
                if (i == intervals.length - 2) {
                    list.add(intervals[i + 1]);
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }

}
