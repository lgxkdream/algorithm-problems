package io.github.lgxkdream.test.unit14;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 130. 被围绕的区域
 * @description https://leetcode-cn.com/problems/surrounded-regions/
 * @since 2020-08-11 09:46
 */
public class SurroundedRegions {

    public static void main(String[] args) {
        // char[][] board = {
        //         {'X', 'X', 'X', 'X'},
        //         {'X', 'O', 'O', 'X'},
        //         {'X', 'X', 'O', 'X'},
        //         {'X', 'O', 'X', 'X'}
        // };
        char[][] board = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'O', 'X'}
        };
        solve(board);
        /**
         * 输出:
         * X X X X
         * X X X X
         * X X X X
         * X O X X
         *
         * 解释:
         * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
         * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
         *
         */
        System.out.println(Arrays.deepToString(board));
    }

    /**
     * 广度优先遍历思想
     *
     * @param board
     */
    public static void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int left = 0, right = board[0].length, top = 0, bottom = board.length;
        int[][] isO = new int[bottom][right];
        Queue<int[]> queue = new LinkedList<>();
        // 找出外围是'O'的
        for (int i = left; i < right - 1; i++) {
            if (board[top][i] == 'O') {
                isO[top][i] = 1;
                queue.offer(new int[]{top, i});
            }
            if (board[bottom - 1][i] == 'O') {
                isO[bottom - 1][i] = 1;
                queue.offer(new int[]{bottom - 1, i});
            }
        }
        for (int i = 1; i < bottom - 1; i++) {
            if (board[i][left] == 'O') {
                isO[i][left] = 1;
                queue.offer(new int[]{i, left});
            }
            if (board[i][right - 1] == 'O') {
                isO[i][right - 1] = 1;
                queue.offer(new int[]{i, right - 1});
            }
        }
        // 广度优先遍历标记出所有是'O'的
        int[] dxy = {1, 0, -1, 0, 1};
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int dx = poll[0] + dxy[i], dy = poll[1] + dxy[i + 1];
                if (dx >= top && dx < bottom && dy >= left && dy < right && board[dx][dy] == 'O' && isO[dx][dy] != 1) {
                    isO[dx][dy] = 1;
                    queue.offer(new int[]{dx, dy});
                }
            }
        }
        // 将所有不是'O'的标记为'X'
        for (int i = top; i < bottom - 1; i++) {
            for (int j = left; j < right - 1; j++) {
                if (isO[i][j] != 1) {
                    board[i][j] = 'X';
                }
            }
        }
    }

}
