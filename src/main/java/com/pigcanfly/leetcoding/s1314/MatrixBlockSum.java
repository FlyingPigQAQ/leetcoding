package com.pigcanfly.leetcoding.s1314;

/**
 * @author tobbyquinn
 * @date 2020/01/16
 */
public class MatrixBlockSum {
    /**
     * Brute Force
     * @param mat
     * @param K
     * @return
     */
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int[][] res = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                //统计
                int kStart = Math.max(i - K, 0), kEnd = Math.min(i + K, mat.length - 1);
                int lStart = Math.max(j - K, 0), lEnd = Math.min(j + K, mat[0].length - 1);
                int sum = 0;
                for (int k = kStart; k <= kEnd; k++) {
                    for (int l = lStart; l <= lEnd; l++) {
                        sum += mat[k][l];
                    }
                }
                res[i][j] = sum;
            }
        }
        return res;
    }

    /**
     *
     * O(M*N)
     * @param mat
     * @param K
     * @return
     */
    public int[][] matrixBlockSum1(int[][] mat, int K) {
        int m = mat.length, n = mat[0].length;
        int[][] sum = new int[m + 1][n + 1]; // sum[i][j] is sum of all elements from rectangle (0,0,i,j) as left, top, right, bottom corresponding
        for (int r = 1; r <= m; r++) {
            for (int c = 1; c <= n; c++) {
                sum[r][c] = mat[r - 1][c - 1] + sum[r - 1][c] + sum[r][c - 1] - sum[r - 1][c - 1];
            }
        }
        int[][] ans = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int r1 = Math.max(0, r - K), c1 = Math.max(0, c - K);
                int r2 = Math.min(m - 1, r + K), c2 = Math.min(n - 1, c + K);
                r1++; c1++; r2++; c2++; // Since `sum` start with 1 so we need to increase r1, c1, r2, c2 by 1
                ans[r][c] = sum[r2][c2] - sum[r2][c1-1] - sum[r1-1][c2] + sum[r1-1][c1-1];
            }
        }
        return ans;
    }
}
