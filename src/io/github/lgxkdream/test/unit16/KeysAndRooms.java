package io.github.lgxkdream.test.unit16;

import com.google.common.collect.Lists;

import java.util.List;

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
        List<List<Integer>> rooms = Lists.newArrayList(Lists.newArrayList(1), Lists.newArrayList(2), Lists.newArrayList(3), Lists.newArrayList(2));
        System.out.println(canVisitAllRooms(rooms));
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean result = false;
        return result;
    }

}
