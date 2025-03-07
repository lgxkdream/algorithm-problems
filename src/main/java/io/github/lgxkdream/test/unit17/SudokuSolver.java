package io.github.lgxkdream.test.unit17;

import java.util.Arrays;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 37. 解数独
 * @description https://leetcode-cn.com/problems/sudoku-solver/
 * @since 2020-09-15 09:54
 */
public class SudokuSolver {

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
        };
        solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }

    public static void solveSudoku(char[][] board) {

    }

}
