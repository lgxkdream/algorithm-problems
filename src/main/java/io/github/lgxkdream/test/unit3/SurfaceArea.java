package io.github.lgxkdream.test.unit3;

/**
 * @author Jackie Lee
 * @version 1.0.0
 * @title SurfaceArea
 * @description
 * @since 2020-03-25 12:36
 */
public class SurfaceArea {

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int area = surfaceArea(grid);
        System.out.println(area);

        System.out.println(192 << 24);
        System.out.println(168 << 16);
        System.out.println(1 << 8);

        System.out.println(192 * 256 * 256 * 256);
        System.out.println(168 * 256 * 256);

        long a = (192L << 24) + (168L << 16) + (1 << 8) + 38;

        // 192.168.1.38
        System.out.println(a);
    }

    public static int surfaceArea(int[][] grid) {
        int n = grid.length, area = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int level = grid[i][j];
                if (level > 0) {
                    area += (level << 2) + 2;
                    area -= i > 0 ? Math.min(level, grid[i - 1][j]) << 1 : 0;
                    area -= j > 0 ? Math.min(level, grid[i][j - 1]) << 1 : 0;
                }

            }
        }
        return area;
    }

}
