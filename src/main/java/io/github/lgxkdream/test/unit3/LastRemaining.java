package io.github.lgxkdream.test.unit3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title LastRemaining
 * @description https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * @since 2020-03-30 12:36
 */
public class LastRemaining {

    public static void main(String[] args) {
        int n = 5, m = 3;
        System.out.println(lastRemaining1(n, m));
    }

    public static int lastRemaining1(int n, int m) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(i);
        }
        int count = 1;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (queue.size() == 0) {
                return poll;
            }
            if (count++ % m != 0) {
                queue.offer(poll);
            }
        }
        return -1;
    }

    public static int lastRemaining(int n, int m) {
        if (n == 1) {
            return 0;
        }
        return (lastRemaining(n-1, m) + m) % n - 1;
    }

}
