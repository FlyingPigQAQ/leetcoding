package com.pigcanfly.leetcoding.s867;

/**
 * TODO
 * 该题只是索引的下标发生变化
 * @author Tobby Quinn
 * @date 2019/07/09
 */
public class TransposeMatrix {
    public int[][] transpose(int[][] A) {
        int n = A.length, y = A[0].length;
        int[][] res = new int[y][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < y; j++) {
                res[j][i] = A[i][j];
            }
        }
        return res;
    }
}
