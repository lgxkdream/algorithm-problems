package io.github.lgxkdream.test.other;

import java.util.Stack;

/**
 * @author LiGang
 * @version 1.0.0
 * @title Test1
 * @description
 * @since 2019-12-18 20:53
 */
public class Test1 {

    public static Stack<Integer> stack = new Stack<>();

    /**
     * 递归三要素：
     * 结束条件
     * 这层干什么
     * 需不需要返回值
     */
    public static void main(String[] args) {
        int[] shu = {1, 2, 4, 8};

        // 从这个数组4个数中选择三个
        f(shu, 3, 0, 0);
    }

    /**
     * @param shu  元素
     * @param targ 要选多少个元素
     * @param has  当前有多少个元素
     * @param cur  当前选到的下标
     *             <p>
     *             1    2   3     //开始下标到2
     *             1    2   4     //然后从3开始
     */
    private static void f(int[] shu, int targ, int has, int cur) {
        if (has == targ) {
            // System.out.print(cur + " ");
            System.out.println(stack);
            return;
        }

        for (int i = cur; i < shu.length; i++) {
            // if (!stack.contains(shu[i])) {
                stack.add(shu[i]);
                f(shu, targ, has + 1, i + 1);
                stack.pop();
            // }
        }

    }
}