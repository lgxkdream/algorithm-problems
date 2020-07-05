package io.github.lgxkdream.test.unit10;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 面试题46. 把数字翻译成字符串
 * @description https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 * @since 2020-06-09 09:59
 */
public class BaShuZiFanYiChengZiFuChuanLcof {

    public static void main(String[] args) {
        /**
         * 输出: 5
         * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
         */
        System.out.println(translateNum(12258));
    }

    public static int translateNum(int num) {
        if (num < 10) {
            return 1;
        }
        int remainder = num % 100;
        if (remainder < 10 || remainder > 25) {
            return translateNum(num / 10);
        } else {
            return translateNum(num / 10) + translateNum(num / 100);
        }
    }

}
