package io.github.lgxkdream.test.unit3;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title 999. 可以被一步捕获的棋子数
 * @description https://leetcode-cn.com/problems/available-captures-for-rook/
 * @since 2020-03-26 10:22
 */
public class NumRookCaptures {

    public static void main(String[] args) {
        char[][] board = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'p', 'p', '.', 'R', '.', 'p', 'B', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'B', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}};
        System.out.println(numRookCaptures(board));
    }

    public static int numRookCaptures(char[][] board) {
        int result = 0;
        int length = board.length;
        int a = 0, b = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i][j] == 'R') {
                    a = i;
                    b = j;
                    break;
                }
            }
        }
        for (int i = b; i >= 0; i--) {
            if (board[a][i] == 'B') {
                break;
            }
            if (board[a][i] == 'p') {
                result++;
                break;
            }
        }
        for (int i = b; i < 8; i++) {
            if (board[a][i] == 'B') {
                break;
            }
            if (board[a][i] == 'p') {
                result++;
                break;
            }
        }
        for (int i = a; i >= 0; i--) {
            if (board[i][b] == 'B') {
                break;
            }
            if (board[i][b] == 'p') {
                result++;
                break;
            }
        }
        for (int i = a; i < 8; i++) {
            if (board[i][b] == 'B') {
                break;
            }
            if (board[i][b] == 'p') {
                result++;
                break;
            }
        }
        return result;
    }

}
