package io.github.lgxkdream.unit7;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 401. 二进制手表
 * @description https://leetcode-cn.com/problems/binary-watch/
 * @since 6/21/21 11:48 PM
 */
public class BinaryWatch {


    public static void main(String[] args) {
        /**
         * 输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
         */
        System.out.println(readBinaryWatch(1));
        /**
         * 输出：[]
         */
        System.out.println(readBinaryWatch(9));
    }

    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn) {
                    res.add(j < 10 ? i + ":0" + j : i + ":" + j);
                }
            }
        }
        return res;
    }

}
