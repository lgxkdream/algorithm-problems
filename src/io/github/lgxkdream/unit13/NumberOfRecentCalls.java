package io.github.lgxkdream.unit13;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 933. 最近的请求次数
 * @description https://leetcode-cn.com/problems/number-of-recent-calls/
 * @since 5/6/22 8:25 AM
 */
public class NumberOfRecentCalls {

    public static void main(String[] args) {
        /**
         * 输出：
         * [null, 1, 2, 3, 3]
         *
         * 解释：
         * RecentCounter recentCounter = new RecentCounter();
         * recentCounter.ping(1);     // requests = [1]，范围是 [-2999,1]，返回 1
         * recentCounter.ping(100);   // requests = [1, 100]，范围是 [-2900,100]，返回 2
         * recentCounter.ping(3001);  // requests = [1, 100, 3001]，范围是 [1,3001]，返回 3
         * recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002]，范围是 [2,3002]，返回 3
         */
        RecentCounter rc = new RecentCounter();
        System.out.println(rc.ping(1));
        System.out.println(rc.ping(100));
        System.out.println(rc.ping(3001));
        System.out.println(rc.ping(3002));
    }

}

class RecentCounter {

    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);
        int left = t - 3000;
        while (queue.peek() < left) {
            queue.poll();
        }
        return queue.size();
    }

}