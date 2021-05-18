package io.github.lgxkdream.unit6;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 1442. 形成两个异或相等数组的三元组数目
 * @description
 * @since 5/18/21 11:19 PM
 */
public class CountTripletsThatCanFormTwoArraysOfEqualXor {

    public static void main(String[] args) {
        /**
         * 输出：4
         * 解释：满足题意的三元组分别是 (0,1,2), (0,2,2), (2,3,4) 以及 (2,4,4)
         */
        System.out.println(countTriplets(new int[]{2, 3, 1, 6, 7}));
        /**
         * 输出：10
         */
        System.out.println(countTriplets(new int[]{1, 1, 1, 1, 1}));
        /**
         * 输出：0
         */
        System.out.println(countTriplets(new int[]{2, 3}));
        /**
         * 输出：3
         */
        System.out.println(countTriplets(new int[]{1, 3, 5, 7, 9}));
        /**
         * 输出：8
         */
        System.out.println(countTriplets(new int[]{7, 11, 12, 9, 5, 2, 7, 17, 22}));
    }

    /**
     * a = Si⊕Sj
     * ​b = Sj⊕Sk+1
     * ​
     * Si⊕Sj = Sj⊕Sk+1
     * <p>
     * Si = Sk+1
     * <p>
     * arri⊕arri+1⊕ ⋯ ⊕ arrk = 0
     */
    public static int countTriplets(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int sum = 0;
            for (int k = i; k < arr.length; k++) {
                sum ^= arr[k];
                if (sum == 0 && k > i) {
                    res += k - i;
                }
            }
        }
        return res;
    }

}
