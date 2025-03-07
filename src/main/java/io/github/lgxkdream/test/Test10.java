package io.github.lgxkdream.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title
 * @description
 * @since 2020-05-13 20:45
 */
public class Test10 {

    /**
     * == 题目 ==
     * 我们有一堆商品，要装到箱子中。已知箱子的容积是3，也知道每个商品的体积。
     * 简化难度：
     * 1. 不考虑商品的形状，假设只要N个商品的体积加和，恰好是3，就可以装进箱子。
     * 2. 如果商品的体积超过了3，只要恰好是箱子体积的倍数，可以把多个箱子拼成1个大箱子，来装商品。
     * <p>
     * 找出一批商品，恰好装满M个箱子。
     * 你能找到的最大的M，是多少？
     */
    private static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {
        int max = -1;
        int[] nums = {2, 5, 7, 1, 4, 7};
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= nums.length; i++) {
            test(stack, nums, 0, i);
        }
        System.out.println(list);
        for (List<Integer> result : list) {
            int count = 0;
            for (Integer integer : result) {
                count += integer;
            }
            if (count % 3 == 0) {
                max = Math.max(max, count / 3);
            }
        }
        System.out.println(max);
    }

    private static void test1(int[] input) {
        int len = input.length;
        int res = 0;
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (input[i] % 3 == 0) {
                res += input[i] / 3;
            } else {
                arr.add(input[i]);
            }
        }
        Collections.sort(arr);
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if ((arr.get(i) + arr.get(j)) % 3 == 0) {
                    res += (arr.get(i) + arr.get(j)) / 3;
                    i = i + j;
                }
            }
        }
        System.out.println(res);
    }

    private static void test(Stack<Integer> stack, int[] nums, int start, int count) {
        if (stack.size() == count) {
            list.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            // if (!stack.contains(nums[i])) {
            stack.push(nums[i]);
            test(stack, nums, i + 1, count);
            stack.pop();
            // }
        }
    }

}
