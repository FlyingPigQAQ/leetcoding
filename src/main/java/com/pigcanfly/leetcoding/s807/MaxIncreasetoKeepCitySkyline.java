package com.pigcanfly.leetcoding.s807;

/**
 * @author Tobby Quinn
 * @date 2019/07/12
 */
public class MaxIncreasetoKeepCitySkyline {
    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] horizontal = new int[n];
        int[] vertical = new int[m];
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                horizontal[i] = Math.max(horizontal[i], grid[i][j]);
                vertical[j] = Math.max(vertical[j], grid[i][j]);
            }

        }
        int res = 0;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                res += Math.min(horizontal[i], vertical[j]) - grid[i][j];
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arg = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        maxIncreaseKeepingSkyline(arg);
    }
}
