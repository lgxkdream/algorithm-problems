package io.github.lgxkdream.test.unit9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 拥有最多糖果的孩子
 * @description https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/
 * @since 2020-06-01 10:04
 */
public class KidsWithTheGreatestNumberOfCandies {

    public static void main(String[] args) {
        /**
         * 输出：[true,true,true,false,true]
         * 解释：
         * 孩子 1 有 2 个糖果，如果他得到所有额外的糖果（3个），那么他总共有 5 个糖果，他将成为拥有最多糖果的孩子。
         * 孩子 2 有 3 个糖果，如果他得到至少 2 个额外糖果，那么他将成为拥有最多糖果的孩子。
         * 孩子 3 有 5 个糖果，他已经是拥有最多糖果的孩子。
         * 孩子 4 有 1 个糖果，即使他得到所有额外的糖果，他也只有 4 个糖果，无法成为拥有糖果最多的孩子。
         * 孩子 5 有 3 个糖果，如果他得到至少 2 个额外糖果，那么他将成为拥有最多糖果的孩子。
         */
        System.out.println(kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3));

        /**
         * 输出：[true,false,false,false,false]
         * 解释：只有 1 个额外糖果，所以不管额外糖果给谁，只有孩子 1 可以成为拥有糖果最多的孩子。
         */
        System.out.println(kidsWithCandies(new int[]{4, 2, 1, 1, 2}, 1));

        /**
         * 输出：[true,false,true]
         */
        System.out.println(kidsWithCandies(new int[]{12, 1, 12}, 10));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // 找出最大值
        int max = Arrays.stream(candies).max().getAsInt();
        // 得出结果
        return Arrays.stream(candies).mapToObj(candy -> (candy + extraCandies) >= max).collect(Collectors.toList());
    }

}
