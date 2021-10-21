package io.github.lgxkdream.unit10;

import java.util.Arrays;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 66. 加一
 * @description https://leetcode-cn.com/problems/plus-one/
 * @since 2021-10-21 21:15
 */
public class PlusOne {

    public static void main(String[] args) {
        /**
         * 输出：[1,2,4]
         * 解释：输入数组表示数字 123。
         */
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
        /**
         * 输出：[4,3,2,2]
         * 解释：输入数组表示数字 4321。
         */
        System.out.println(Arrays.toString(plusOne(new int[]{4, 3, 2, 1})));
        /**
         * 输出：[1]
         */
        System.out.println(Arrays.toString(plusOne(new int[]{0})));
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                break;
            }
        }
        if (digits[0] == 0) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        return digits;
    }

}
