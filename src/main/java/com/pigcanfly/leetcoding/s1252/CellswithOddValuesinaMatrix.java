package com.pigcanfly.leetcoding.s1252;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author tobbyquinn
 * @date 2019/11/21
 */
public class CellswithOddValuesinaMatrix {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] cache = new int[n][m];
        int odd=0;
        for (int[] index : indices) {
            int row=index[0];
            for (int i = 0; i < m; i++) {
                cache[row][i]++;
            }
            int col=index[1];
            for (int i = 0; i < n; i++) {
                cache[i][col]++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(cache[i][j]%2!=0){
                    odd++;
                }
            }
        }
        return odd;
    }

    public static void main(String[] args) {

    }
}
