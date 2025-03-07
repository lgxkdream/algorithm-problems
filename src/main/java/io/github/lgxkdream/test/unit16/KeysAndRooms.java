package io.github.lgxkdream.test.unit16;

import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 841. 钥匙和房间
 * @description https://leetcode-cn.com/problems/keys-and-rooms/
 * @since 2020-08-31 21:15
 */
public class KeysAndRooms {

    public static void main(String[] args) {
        /**
         * 输出: true
         * 解释:
         * 我们从 0 号房间开始，拿到钥匙 1。
         * 之后我们去 1 号房间，拿到钥匙 2。
         * 然后我们去 2 号房间，拿到钥匙 3。
         * 最后我们去了 3 号房间。
         * 由于我们能够进入每个房间，我们返回 true。
         */
        List<List<Integer>> rooms = Lists.newArrayList(Lists.newArrayList(1), Lists.newArrayList(2), Lists.newArrayList(3), Lists.newArrayList());
        System.out.println(canVisitAllRooms2(rooms));
        /**
         * 输出：false
         * 解释：我们不能进入 2 号房间。
         */
        rooms = Lists.newArrayList(Lists.newArrayList(1, 3), Lists.newArrayList(3, 0, 1), Lists.newArrayList(2), Lists.newArrayList(0));
        System.out.println(canVisitAllRooms2(rooms));
    }

    private static int num;

    /**
     * 深度优先遍历思想
     */
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size = rooms.size();
        boolean[] visited = new boolean[size];
        canVisitAllRooms(rooms, visited, 0);
        return num == size;
    }

    private static void canVisitAllRooms(List<List<Integer>> rooms, boolean[] visited, int index) {
        num++;
        visited[index] = true;
        List<Integer> keys = rooms.get(index);
        for (Integer key : keys) {
            if (!visited[key]) {
                canVisitAllRooms(rooms, visited, key);
            }
        }
    }

    /**
     * 广度优先遍历思想
     */
    public static boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        int size = rooms.size(), num = 0;
        boolean[] visited = new boolean[size];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (!visited[poll]) {
                num++;
                visited[poll] = true;
                List<Integer> keys = rooms.get(poll);
                for (Integer key : keys) {
                    queue.offer(key);
                }
            }
        }
        return num == size;
    }

}
