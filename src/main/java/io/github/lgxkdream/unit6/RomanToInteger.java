package io.github.lgxkdream.unit6;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 13. 罗马数字转整数
 * @description https://leetcode-cn.com/problems/roman-to-integer/
 * @since 5/15/21 3:47 PM
 */
public class RomanToInteger {

    public static void main(String[] args) {
        /**
         * 输出: 3
         */
        System.out.println(romanToInt("III"));
        /**
         * 输出: 4
         */
        System.out.println(romanToInt("IV"));
        /**
         * 输出: 9
         */
        System.out.println(romanToInt("IX"));
        /**
         * 输出: 58
         * 解释: L = 50, V= 5, III = 3.
         */
        System.out.println(romanToInt("LVIII"));
        /**
         * 输出: 1994
         * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
         */
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I' , 1);
        map.put('V' , 5);
        map.put('X' , 10);
        map.put('L' , 50);
        map.put('C' , 100);
        map.put('D' , 500);
        map.put('M' , 1000);
        int res = 0, len = s.length();
        for (int i = 0; i < len; i++) {
            if (i < len - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                res -= map.get(s.charAt(i));
            } else {
                res += map.get(s.charAt(i));
            }
        }
        return res;
    }

}
