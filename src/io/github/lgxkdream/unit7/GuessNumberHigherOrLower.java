package io.github.lgxkdream.unit7;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 374. 猜数字大小
 * @description https://leetcode-cn.com/problems/guess-number-higher-or-lower/submissions/
 * @since 6/14/21 9:48 PM
 */
public class GuessNumberHigherOrLower extends GuessGame {

    public static void main(String[] args) {
        // 1 2 3 4 5 6 7 8 9 10
        // 6
    }

    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}

class GuessGame {
    int guess(int num) {
        return 0;
    }
}
