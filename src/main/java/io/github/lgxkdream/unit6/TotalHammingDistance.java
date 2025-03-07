package io.github.lgxkdream.unit6;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 477. 汉明距离总和
 * @description https://leetcode-cn.com/problems/total-hamming-distance/
 * @since 5/28/21 10:58 PM
 */
public class TotalHammingDistance {

    public static void main(String[] args) {
        /**
         * 输出: 6
         *
         * 解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
         * 所以答案为：
         * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
         */
        System.out.println(totalHammingDistance(new int[]{4, 14, 2}));
    }

    public static int totalHammingDistance(int[] nums) {
        int len = nums.length, shift = 0, res = 0;
        while (true) {
            int count = 0, zeroCount = 0;
            for (int num : nums) {
                num >>= shift;
                count += (num & 1);
                if (num == 0) {
                    zeroCount++;
                }
            }
            if (zeroCount == len) {
                break;
            }
            shift++;
            res += count * (len - count);
        }
        return res;
    }

}
