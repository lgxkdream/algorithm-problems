package io.github.lgxkdream.test.unit1;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title Test0311
 * @description
 * @since 2020-03-11 20:56
 */
public class Test0311 {

    public static void main(String[] args) {
        String str = "JHsdjLJNC";
        System.out.println(str.charAt(2));
        System.out.println((int) str.charAt(2)); // 89+19 = 108
        System.out.println(FirstNotRepeatingChar("xicuwkcenfoixusdf"));
    }

    /**
     * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
     * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）
     *
     * @param str
     * @return
     */
    public static int FirstNotRepeatingChar(String str) {
        int[] nums = new int[58];
        for (char c : str.toCharArray()) {
            nums[(int) c - 65]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (nums[str.charAt(i) - 65] == 1) {
                return i;
            }
        }
        return -1;
    }

}
