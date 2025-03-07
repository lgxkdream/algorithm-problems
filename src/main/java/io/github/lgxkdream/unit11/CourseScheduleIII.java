package io.github.lgxkdream.unit11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 630. 课程表 III
 * @description https://leetcode-cn.com/problems/course-schedule-iii/
 * @since 12/14/21 11:02 PM
 */
public class CourseScheduleIII {

    public static void main(String[] args) {
        /**
         * 输出：3
         * 解释：
         * 这里一共有 4 门课程，但是你最多可以修 3 门：
         * 首先，修第 1 门课，耗费 100 天，在第 100 天完成，在第 101 天开始下门课。
         * 第二，修第 3 门课，耗费 1000 天，在第 1100 天完成，在第 1101 天开始下门课程。
         * 第三，修第 2 门课，耗时 200 天，在第 1300 天完成。
         * 第 4 门课现在不能修，因为将会在第 3300 天完成它，这已经超出了关闭日期。
         */
        System.out.println(scheduleCourse(new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}}));
        /**
         * 输出：1
         */
        System.out.println(scheduleCourse(new int[][]{{1, 2}}));
        /**
         * 输出：0
         */
        System.out.println(scheduleCourse(new int[][]{{3, 2}, {4, 3}}));
    }

    // 贪心
    public static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(course -> course[1]));
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int count = 0;
        for (int[] course : courses) {
            if (count + course[0] <= course[1]) {
                count += course[0];
                queue.offer(course[0]);
            } else if (!queue.isEmpty() && queue.peek() > course[0]) {
                count -= queue.poll() - course[0];
                queue.offer(course[0]);
            }
        }
        return queue.size();
    }

}
