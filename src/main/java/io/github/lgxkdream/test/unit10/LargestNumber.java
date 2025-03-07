package io.github.lgxkdream.test.unit10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 179. 最大数
 * @description https://leetcode-cn.com/problems/largest-number/
 * @since 2020-06-15 20:35
 */
public class LargestNumber {

    public static void main(String[] args) throws Exception {
        System.out.println(largestNumber(new int[]{12, 24, 55, 5516, 56121, 54, 88, 9}));
    }

    public static String largestNumber(int[] nums) {
        List<String> strList = new ArrayList<>();
        for (int num : nums) {
            String s = String.valueOf(num);
            strList.add(s);
        }
        Collections.sort(strList, (a, b) -> {
            String s1 = a + b;
            String s2 = b + a;
            return s2.compareTo(s1);
        });
        if ("0".equals(strList.get(0))) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : strList) {
            sb.append(s);
        }
        return sb.toString();
    }

}
