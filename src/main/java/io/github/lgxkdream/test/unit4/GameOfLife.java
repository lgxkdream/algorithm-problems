package io.github.lgxkdream.test.unit4;

import java.util.Arrays;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title GameOfLife
 * @description https://leetcode-cn.com/problems/game-of-life/
 * @since 2020-04-02 10:05
 */
public class GameOfLife {

    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}};
        gameOfLife(board);
        Arrays.stream(board).forEach(item -> {
            Arrays.stream(item).forEach(System.out::print);
            System.out.println();
        });
    }

    public static void gameOfLife(int[][] board) {
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int ch = 0;
                for (int k = 0; k < 8; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x < 0 || x >= n || y < 0 || y >= m) {
                        continue;
                    }
                    ch += board[x][y] & 1;
                }
                if ((board[i][j] & 1) == 0 && ch == 3) {
                    board[i][j] = 2;
                } else if ((board[i][j] & 1) == 1 && (ch == 2 || ch == 3)) {
                    board[i][j] = 3;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] >>= 1;
            }
        }
    }

}
