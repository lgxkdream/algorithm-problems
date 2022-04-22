package io.github.lgxkdream.unit12;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 396. 旋转函数
 * @description https://leetcode-cn.com/problems/rotate-function/
 * @since 4/22/22 8:13 AM
 */
public class RotateFunction {

    public static void main(String[] args) {
        /**
         * 输出: 26
         * 解释:
         * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
         * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
         * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
         * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
         * 所以 F(0), F(1), F(2), F(3) 中的最大值是 F(3) = 26 。
         */
        System.out.println(maxRotateFunction(new int[]{4, 3, 2, 6}));
        /**
         * 输出: 0
         */
        System.out.println(maxRotateFunction(new int[]{100}));
        /**
         * 输出: 330
         */
        System.out.println(maxRotateFunction(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }

    /**
     * F(0) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1]
     * F(1) = 1 * arrk[0] + 2 * arrk[1] + ... + 0 * arrk[n - 1] = F(0) + sum - n * arrk[n - 1]
     */
    public static int maxRotateFunction(int[] nums) {
        int len = nums.length, sum = 0, f = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            f += i * nums[i];
        }
        int res = f;
        for (int i = 1; i < nums.length; i++) {
            int nf = f + sum - len * nums[len - i];
            res = Math.max(res, nf);
            f = nf;
        }

        return res;
    }

}
