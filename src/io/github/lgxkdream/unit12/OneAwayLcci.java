package io.github.lgxkdream.unit12;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 面试题 01.05. 一次编辑
 * @description
 * @since 2022-05-13 11:20
 */
public class OneAwayLcci {

    public static void main(String[] args) {
        /**
         * 输出: True
         */
        System.out.println(oneEditAway("pale", "ple"));
        /**
         * 输出: False
         */
        System.out.println(oneEditAway("pales", "pal"));
    }

    public static boolean oneEditAway(String first, String second) {
        int fl = first.length(), sl = second.length();
        if (Math.abs(fl - sl) > 1) {
            return false;
        }
        int diff = 0;
        if (fl == sl) {
            for (int i = 0; i < fl; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    diff++;
                }
            }
        } else {
            if (fl > sl) {
                return oneEditAway(second, first);
            }
            int i = 0, j = 0;
            while (i < fl && j < sl && diff <= 1) {
                if (first.charAt(i) != second.charAt(j)) {
                    diff++;
                    j++;
                } else {
                    i++;
                    j++;
                }
            }
        }
        return diff <= 1;
    }

}
