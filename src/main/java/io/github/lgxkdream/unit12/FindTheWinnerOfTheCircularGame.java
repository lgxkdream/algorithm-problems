package io.github.lgxkdream.unit12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 1823. 找出游戏的获胜者
 * @description https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game/
 * @since 5/4/22 9:54 PM
 */
public class FindTheWinnerOfTheCircularGame {

    public static void main(String[] args) {
        /**
         * 输出：3
         * 解释：游戏运行步骤如下：
         * 1) 从小伙伴 1 开始。
         * 2) 顺时针数 2 名小伙伴，也就是小伙伴 1 和 2 。
         * 3) 小伙伴 2 离开圈子。下一次从小伙伴 3 开始。
         * 4) 顺时针数 2 名小伙伴，也就是小伙伴 3 和 4 。
         * 5) 小伙伴 4 离开圈子。下一次从小伙伴 5 开始。
         * 6) 顺时针数 2 名小伙伴，也就是小伙伴 5 和 1 。
         * 7) 小伙伴 1 离开圈子。下一次从小伙伴 3 开始。
         * 8) 顺时针数 2 名小伙伴，也就是小伙伴 3 和 5 。
         * 9) 小伙伴 5 离开圈子。只剩下小伙伴 3 。所以小伙伴 3 是游戏的获胜者。
         */
        System.out.println(findTheWinner(5, 2));
        /**
         * 输出：1
         * 解释：小伙伴离开圈子的顺序：5、4、6、2、3 。小伙伴 1 是游戏的获胜者。
         */
        System.out.println(findTheWinner(6, 5));
    }

    /**
     * 队列模拟
     */
    public static int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < k - 1; j++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        return queue.poll();
    }

    /**
     * 有序集合模拟
     */
    public static int findTheWinner1(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1) {
            index = (index + k - 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }

}
