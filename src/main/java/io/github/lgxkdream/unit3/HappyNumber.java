package io.github.lgxkdream.unit3;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 快乐数
 * @description https://leetcode-cn.com/problems/happy-number/
 * @since 2020-04-30 09:57
 */
public class HappyNumber {

    public static void main(String[] args) {
        /**
         * 输入：19
         * 输出：true
         * 解释：
         * 12 + 92 = 82
         * 82 + 22 = 68
         * 62 + 82 = 100
         * 12 + 02 + 02 = 1
         */
        System.out.println(getNext(19));
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        int slow = n, fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    private static int getNext(int n) {
        int result = 0;
        while (n != 0) {
            int d = n % 10;
            n = n / 10;
            result += d * d;
        }
        return result;
    }

}
