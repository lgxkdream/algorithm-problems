package io.github.lgxkdream.test.unit7;

import java.util.*;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 课程表 II
 * @description https://leetcode-cn.com/problems/course-schedule-ii/
 * @since 2020-05-17 09:40
 */
public class CourseScheduleII {

    public static void main(String[] args) {
        /**
         * 输出: [0,1]
         * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
         */
        System.out.println(Arrays.toString(findOrder(2, new int[][]{{1, 0}})));

        /**
         * 输出: [0,1,2,3] or [0,2,1,3]
         * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
         *      因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
         */
        System.out.println(Arrays.toString(findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
    }

    /**
     * 拓扑排序 广度优先搜索
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        // 统计课程入度
        int[] input = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            input[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            // 入度为0没有先决条件，先入队
            if (input[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            list.add(poll);
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == poll) {
                    // 修改入度，如果入度为0则入队
                    if (--input[prerequisite[0]] == 0) {
                        queue.offer(prerequisite[0]);
                    }
                }
            }

        }
        // 如果结果个数为总课程个数，则证明可以完成所有课程
        if (list.size() == numCourses) {
            // 集合转数组
            return list.stream().mapToInt(Integer::valueOf).toArray();
        }
        return new int[0];
    }

}
