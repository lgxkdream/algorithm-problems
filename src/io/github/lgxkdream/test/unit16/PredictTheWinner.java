package io.github.lgxkdream.test.unit16;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 486. 预测赢家
 * @description https://leetcode-cn.com/problems/predict-the-winner/
 * @since 2020-09-01 09:53
 */
public class PredictTheWinner {

    public static void main(String[] args) {
        /**
         * 输出：False
         * 解释：一开始，玩家1可以从1和2中进行选择。
         * 如果他选择 2（或者 1 ），那么玩家 2 可以从 1（或者 2 ）和 5 中进行选择。如果玩家 2 选择了 5 ，那么玩家 1 则只剩下 1（或者 2 ）可选。
         * 所以，玩家 1 的最终分数为 1 + 2 = 3，而玩家 2 为 5 。
         * 因此，玩家 1 永远不会成为赢家，返回 False 。
         */
        System.out.println(PredictTheWinner(new int[]{1, 5, 2}));
        /**
         * 输出：True
         * 解释：玩家 1 一开始选择 1 。然后玩家 2 必须从 5 和 7 中进行选择。无论玩家 2 选择了哪个，玩家 1 都可以选择 233 。
         *      最终，玩家 1（234 分）比玩家 2（12 分）获得更多的分数，所以返回 True，表示玩家 1 可以成为赢家。
         */
        System.out.println(PredictTheWinner(new int[]{1, 5, 233, 7}));
    }

    public static boolean PredictTheWinner(int[] nums) {
        return false;
    }

}
