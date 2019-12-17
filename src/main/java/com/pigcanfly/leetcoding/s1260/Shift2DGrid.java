package com.pigcanfly.leetcoding.s1260;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tobbyquinn
 * @date 2019/12/13
 */
public class Shift2DGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        ArrayList<List<Integer>> res = new ArrayList<>(grid.length);
        for (int i = 0; i < grid.length; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = 0; j < grid[i].length; j++) {
                arr.add(0);
            }
            res.add(arr);
        }
        for (int i = 0; i <= grid.length - 1; i++) {
            for (int j = 0; j <= grid[i].length-1; j++) {
                int sum = i * grid[0].length + j + k;
                int div = ((sum) / grid[0].length)% grid.length;
                int mod = (sum) % grid[0].length;
                res.get(div).set(mod,grid[i][j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arg ={{1},{2},{3},{4},{7},{6},{5}};
        System.out.println(new Shift2DGrid().shiftGrid(arg, 23));
    }
}
