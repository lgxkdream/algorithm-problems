package io.github.lgxkdream.test.unit6;

import java.util.Arrays;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 面试题56 - I. 数组中数字出现的次数
 * @description https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 * @since 2020-04-28 10:24
 */
public class SingleNumbers {

    public static void main(String[] args) {
        System.out.println(0 ^ 1 ^ 2 ^ 10 ^ 4 ^ 1 ^ 4 ^ 3 ^ 3);
        int[] nums = {4, 1, 4, 6};
        System.out.println(Arrays.toString(singleNumbers(nums))); // [1,6] 或 [6,1]
        int[] nums1 = {1, 2, 10, 4, 1, 4, 3, 3};
        System.out.println(Arrays.toString(singleNumbers1(nums1))); // [2,10] 或 [10,2]
    }

    public static int[] singleNumbers(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        int flag = 1;
        while ((sum & flag) == 0) {
            flag <<= 1;
        }
        int result = 0;
        for (int num : nums) {
            if ((num & flag) == 0) {
                result ^= num;
            }
        }
        return new int[]{result, result ^ sum};
    }

    // 假设结果数为A B
    public static int[] singleNumbers1(int[] nums) {
        int x = 0; // 用于记录 A B 的异或结果

        /** 得到A^B的结果
         基于异或运算的以下几个性质
         1. 交换律
         2. 结合律
         3. 对于任何数x，都有x^x=0，x^0=x
         */
        for (int val : nums) {
            x ^= val;
        }

        // x & (-x)本身的作用是得到最低位的1，
        int flag = x & (-x);
        // 而我们所需要的做到的是：利用这个1来进行分组，也就是做到将A和B区分开
        // 前面已经知道，x是我们需要的结果数A和B相异或的结果，也就是说，x的二进制串上的任何一个1，都能成为区分A和B的条件
        // 因此我们只需要得到x上的任意一个1，就可以做到将A和B区分开来


        int res = 0; // 用于记录A或B其中一者

        // 分组操作
        for (int val : nums) {
            // 根据二进制位上的那个“1”进行分组
            // 需要注意的是，分组的结果必然是相同的数在相同的组，且还有一个结果数
            // 因此每组的数再与res=0一路异或下去，最终会得到那个结果数A或B
            // 且由于异或运算具有自反性，因此只需得到其中一个数即可
            if ((flag & val) != 0) {
                res ^= val;
            }
        }
        // 利用先前的x进行异或运算得到另一个，即利用自反性
        return new int[] {res, x ^ res};
    }

}
