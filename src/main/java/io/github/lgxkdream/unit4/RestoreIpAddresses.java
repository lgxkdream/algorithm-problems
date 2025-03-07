package io.github.lgxkdream.unit4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 93. 复原IP地址
 * @description https://leetcode-cn.com/problems/restore-ip-addresses/
 * @since 2020-08-09 22:04
 */
public class RestoreIpAddresses {

    public static void main(String[] args) {
        /**
         * 输出: ["255.255.11.135", "255.255.111.35"]
         */
        System.out.println(restoreIpAddresses("25525511135"));
        /**
         * 输出: ["0.10.0.10","0.100.1.0"]
         */
        System.out.println(restoreIpAddresses("0279245587303"));
    }

    /**
     * 暴力解法
     *
     * @param s
     * @return
     */
    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                for (int k = 1; k < 4; k++) {
                    if ((i + j + k) < s.length() && (s.length() - i - j - k) < 3) {
                        int a = Integer.valueOf(s.substring(0, i));
                        int b = Integer.valueOf(s.substring(i, i + j));
                        int c = Integer.valueOf(s.substring(i + j, i + j + k));
                        int d = 0;
                        String ss = null;
                        try {
                            ss = s.substring(i + j + k);
                            d = Integer.valueOf(ss);
                        } catch (NumberFormatException e) {
                            System.out.println(ss);
                        }
                        if (a <= 255 && b <= 255 && c <= 255 && d <= 255) {
                            String ipStr = a + "." + b + "." + c + "." + d;
                            if (ipStr.length() == s.length() + 3) {
                                result.add(ipStr);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

}
