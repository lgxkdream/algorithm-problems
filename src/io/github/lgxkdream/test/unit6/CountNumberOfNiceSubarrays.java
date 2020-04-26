package io.github.lgxkdream.test.unit6;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 统计「优美子数组」
 * @description https://leetcode-cn.com/problems/count-number-of-nice-subarrays/
 * @since 2020-04-21 10:01
 */
public class CountNumberOfNiceSubarrays {

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 1, 2, 2, 1, 2, 1, 2};
        int k = 2;
        System.out.println(numberOfSubarrays1(nums, k)); // 16
    }

    public static int numberOfSubarrays1(int[] nums, int k) {
        int result = 0;
        // 奇数的个数
        int oddnum = 0;
        // 左右指针的位置
        int l = 0, r = 0;
        while (r < nums.length) {
            if (!isEven(nums[r++])) {
                oddnum++;
            }
            if (oddnum == k) {
                int lEvenNum = 0, rEvenNum = 0;
                while (isEven(nums[l++])) {
                    lEvenNum++;
                }
                oddnum--;
                while (r < nums.length && isEven(nums[r])) {
                    r++;
                    rEvenNum++;
                }
                result += (lEvenNum + 1) * (rEvenNum + 1);
            }
        }
        return result;
    }

    private static boolean isEven(int num) {
        return (num & 1) == 0;
    }


    /*
    (双指针)
    双指针扫描 r 在前，l 在后。
    如果当前位置是奇数，则更新计数器，如果当前 [l, r] 有了恰好 k 个奇数，则移动 l 直到不满足，期间统计出长度为 tot。
    让 ans 累加 tot。
    如果当前位置是偶数，则说明贡献的答案和上一次是奇数的时候一样，直接让 ans 累加上一次的 tot。

    时间复杂度
    每个位置最多遍历两次，故时间复杂度为 O(n)。

    空间复杂度
    仅需要常数的额外空间。
    int[] nums = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
     */
    public static int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;

        // cnt-奇数个数
        int cnt = 0, tot = 0, ans = 0;
        for (int r = 0, l = 0; r < n; r++) {
            if (isOdd(nums[r])) {
                cnt++;
                if (cnt == k) tot = 0;

                while (cnt == k) {
                    tot++;
                    if (isOdd(nums[l]))
                        cnt--;
                    l++;
                }
                ans += tot;
            } else {
                ans += tot;
            }
        }

        return ans;
    }

    // 是否是奇数
    private static boolean isOdd(int n) {
        return (n & 1) != 0;
    }

}
