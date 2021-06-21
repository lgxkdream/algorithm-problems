package io.github.lgxkdream.unit7;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 278. 第一个错误的版本
 * @description https://leetcode-cn.com/problems/first-bad-version/
 * @since 6/13/21 6:59 PM
 */
public class Submissions extends VersionControl {

    public static void main(String[] args) {
        // 1 2 3 4 5
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

}

class VersionControl {
    boolean isBadVersion(int version) {
        return false;
    }
}