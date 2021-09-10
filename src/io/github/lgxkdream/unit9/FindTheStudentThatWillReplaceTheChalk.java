package io.github.lgxkdream.unit9;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 1894. 找到需要补充粉笔的学生编号
 * @description https://leetcode-cn.com/problems/find-the-student-that-will-replace-the-chalk/
 * @since 2021-09-10 21:41
 */
public class FindTheStudentThatWillReplaceTheChalk {

    public static void main(String[] args) {
        /**
         * 输出：0
         * 解释：学生消耗粉笔情况如下：
         * - 编号为 0 的学生使用 5 支粉笔，然后 k = 17 。
         * - 编号为 1 的学生使用 1 支粉笔，然后 k = 16 。
         * - 编号为 2 的学生使用 5 支粉笔，然后 k = 11 。
         * - 编号为 0 的学生使用 5 支粉笔，然后 k = 6 。
         * - 编号为 1 的学生使用 1 支粉笔，然后 k = 5 。
         * - 编号为 2 的学生使用 5 支粉笔，然后 k = 0 。
         * 编号为 0 的学生没有足够的粉笔，所以他需要补充粉笔。
         */
        System.out.println(chalkReplacer(new int[]{5, 1, 5}, 22));
        /**
         * 输出：1
         * 解释：学生消耗粉笔情况如下：
         * - 编号为 0 的学生使用 3 支粉笔，然后 k = 22 。
         * - 编号为 1 的学生使用 4 支粉笔，然后 k = 18 。
         * - 编号为 2 的学生使用 1 支粉笔，然后 k = 17 。
         * - 编号为 3 的学生使用 2 支粉笔，然后 k = 15 。
         * - 编号为 0 的学生使用 3 支粉笔，然后 k = 12 。
         * - 编号为 1 的学生使用 4 支粉笔，然后 k = 8 。
         * - 编号为 2 的学生使用 1 支粉笔，然后 k = 7 。
         * - 编号为 3 的学生使用 2 支粉笔，然后 k = 5 。
         * - 编号为 0 的学生使用 3 支粉笔，然后 k = 2 。
         * 编号为 1 的学生没有足够的粉笔，所以他需要补充粉笔。
         */
        System.out.println(chalkReplacer(new int[]{3, 4, 1, 2}, 25));
    }

    public static int chalkReplacer(int[] chalk, int k) {
        int len = chalk.length;
        if (len <= 1) {
            return 0;
        }
        int[] prefixChalk = new int[len + 1];
        for (int i = 0; i < len; i++) {
            prefixChalk[i + 1] += prefixChalk[i];
            prefixChalk[i + 1] += chalk[i];
        }
        k = k % prefixChalk[len];
        int res = 0;
        for (int i = 0; i <= len; i++) {
            if (k >= prefixChalk[i] && k < prefixChalk[i + 1]) {
                res = i;
                break;
            }
        }
        return res;
    }

}
