package io.github.lgxkdream.unit5;

import java.util.Arrays;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 1720. 解码异或后的数组
 * @description https://leetcode-cn.com/problems/decode-xored-array/
 * @since 5/6/21 12:14 PM
 */
public class DecodeXoredArray {

    public static void main(String[] args) {
        /**
         * 输入：encoded = [1,2,3], first = 1
         * 输出：[1,0,2,1]
         * 解释：若 arr = [1,0,2,1] ，那么 first = 1 且 encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
         */
        System.out.println(Arrays.toString(decode(new int[]{1, 2, 3}, 1)));
        /**
         * 输入：encoded = [6,2,7,3], first = 4
         * 输出：[4,2,0,7,4]
         */
        System.out.println(Arrays.toString(decode(new int[]{6, 2, 7, 3}, 4)));
    }

    public static int[] decode(int[] encoded, int first) {
        int[] res = new int[encoded.length + 1];
        res[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            res[i + 1] = res[i] ^ encoded[i];
        }
        return res;
    }

}
