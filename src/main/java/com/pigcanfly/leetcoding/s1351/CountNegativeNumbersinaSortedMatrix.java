package com.pigcanfly.leetcoding.s1351;

/**
 * @author tobbyquinn
 * @date 2020/02/21
 */
public class CountNegativeNumbersinaSortedMatrix {
    public int countNegatives(int[][] grid) {
        if(grid[grid.length-1][grid[0].length-1]>=0){
            return 0;
        }
        int count=0;
        for (int[] arr : grid) {
            int left=0,right=grid[0].length-1;
            while (left+1<right){
                int mid=left+((right-left)>>1);
                if(arr[mid]<0){
                    right=mid;
                }else {
                    left=mid;
                }
            }
            if(arr[left]<0){
                count+=arr.length;
            }else if(arr[right]<0){
                count+=arr.length-right;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid={{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(new CountNegativeNumbersinaSortedMatrix().countNegatives(grid));
    }
}
