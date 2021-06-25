package io.github.lgxkdream.unit7;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 752. 打开转盘锁
 * @description https://leetcode-cn.com/problems/open-the-lock/
 * @since 2021-06-25 19:42
 */
public class OpenTheLock {

    public static void main(String[] args) {
        /**
         * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
         * 输出：6
         * 解释：
         * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
         * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
         * 因为当拨动到 "0102" 时这个锁就会被锁定。
         */
        System.out.println(openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
        /**
         * 输入: deadends = ["8888"], target = "0009"
         * 输出：1
         * 解释：
         * 把最后一位反向旋转一次即可 "0000" -> "0009"。
         */
        System.out.println(openLock(new String[]{"8888"}, "0009"));
        /**
         * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
         * 输出：-1
         * 解释：
         * 无法旋转到目标数字且不被锁定。
         */
        System.out.println(openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888"));
        /**
         * 输入: deadends = ["0000"], target = "8888"
         * 输出：-1
         */
        System.out.println(openLock(new String[]{"0000"}, "8888"));
    }

    public static int openLock(String[] deadends, String target) {
        return 0;
    }

}
