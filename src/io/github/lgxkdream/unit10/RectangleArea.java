package io.github.lgxkdream.unit10;

/**
 * @author Jacky Lee
 * @version 1.0.0
 * @title 223. 矩形面积
 * @description https://leetcode-cn.com/problems/rectangle-area/
 * @since 2021-09-30 19:25
 */
public class RectangleArea {

    public static void main(String[] args) {
        /**
         * 输出：45
         */
        System.out.println(computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
        /**
         * 输出：16
         */
        System.out.println(computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
    }

    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int total = (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);
        if (!((bx1 > ax2) || (by1 > ay2) || (ax1 > bx2) || (ay1 > by2))) {
            int sub = (Math.min(ax2, bx2) - Math.max(ax1, bx1)) * (Math.min(ay2, by2) - Math.max(ay1, by1));
            total -= sub;
        }
        return total;
    }

}
