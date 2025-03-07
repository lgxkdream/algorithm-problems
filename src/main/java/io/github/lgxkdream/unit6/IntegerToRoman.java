package io.github.lgxkdream.unit6;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 12. 整数转罗马数字
 * @description https://leetcode-cn.com/problems/integer-to-roman/
 * @since 5/15/21 4:09 PM
 */
public class IntegerToRoman {

    public static void main(String[] args) {
        /**
         * 输出: "III"
         */
        System.out.println(intToRoman(3));
        /**
         * 输出: "IV"
         */
        System.out.println(intToRoman(4));
        /**
         * 输出: "IX"
         */
        System.out.println(intToRoman(9));
        /**
         * 输出: "LVIII"
         * 解释: L = 50, V = 5, III = 3.
         */
        System.out.println(intToRoman(58));
        /**
         * 输出: "MCMXCIV"
         * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
         */
        System.out.println(intToRoman(1994));
    }

    public static String intToRoman(int num) {
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            while (num >= entry.getKey()) {
                sb.append(entry.getValue());
                num -= entry.getKey();
            }
            if (num == 0) {
                break;
            }
        }
        return sb.toString();
    }

}
