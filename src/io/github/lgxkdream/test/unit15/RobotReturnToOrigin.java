package io.github.lgxkdream.test.unit15;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 657. 机器人能否返回原点
 * @description https://leetcode-cn.com/problems/robot-return-to-origin/
 * @since 2020-08-28 10:49
 */
public class RobotReturnToOrigin {

    public static void main(String[] args) {
        /**
         * 输出: true
         * 解释：机器人向上移动一次，然后向下移动一次。所有动作都具有相同的幅度，因此它最终回到它开始的原点。因此，我们返回 true。
         */
        System.out.println(judgeCircle("UD"));
        /**
         * 输出: false
         * 解释：机器人向左移动两次。它最终位于原点的左侧，距原点有两次 “移动” 的距离。我们返回 false，因为它在移动结束时没有返回原点。
         */
        System.out.println(judgeCircle("LL"));
    }

    public static boolean judgeCircle(String moves) {
        return false;
    }

}
