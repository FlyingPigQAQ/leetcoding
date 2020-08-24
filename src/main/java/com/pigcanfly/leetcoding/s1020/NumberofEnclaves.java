package com.pigcanfly.leetcoding.s1020;

/**
 * @author tobbyquinn
 * @date 2019/12/27
 */
public class NumberofEnclaves {
    public int numEnclaves(int[][] A) {
        //上到下
        for (int i = 0; i < A[0].length; i++) {
            numEnclaves(A, 0, i);
        }
        //下到上
        for (int i = 0; i < A[0].length; i++) {
            numEnclaves(A, A.length - 1, i);
        }
        //左到右
        for (int i = 0; i < A.length; i++) {
            numEnclaves(A, i, 0);
        }
        //右到左
        for (int i = 0; i < A.length; i++) {
            numEnclaves(A, i, A[0].length - 1);
        }
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public void numEnclaves(int[][] A, int row, int col) {
        if (row < 0 || row >= A.length || col < 0 || col >= A[0].length || A[row][col] == 2 || A[row][col] == 0) {
            return;
        }
        A[row][col] = 2;
        if (row == 0) {
            numEnclaves(A, row +1, col);
        } else if (row == A.length - 1) {
            numEnclaves(A, row - 1, col);
        } else if (col == 0) {
            numEnclaves(A, row, col + 1);
        } else if (col == A[0].length-1) {
            numEnclaves(A, row, col - 1);
        } else {
            numEnclaves(A, row - 1, col);
            numEnclaves(A, row + 1, col);
            numEnclaves(A, row, col - 1);
            numEnclaves(A, row, col + 1);
        }
    }

    public static void main(String[] args) {
        int[][] arg = {{0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1}, {1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0}, {0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0}, {1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1}, {0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1}, {1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0}, {0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0}, {1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0}, {1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1}};
        System.out.println(new NumberofEnclaves().numEnclaves(arg));
    }
}
