package com.pigcanfly.leetcoding.s746;

/**
 * @author tobbyquinn
 * @date 2019/10/12
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int first=0,second=0;
        for (int i = 0; i < cost.length; i++) {
            int third=cost[i]+Math.min(first,second);
            first=second;
            second=third;
        }
        return Math.min(first,second);
    }




    public static void main(String[] args) {
        int[] ints = {1,1,0,0};
        int i = new MinCostClimbingStairs().minCostClimbingStairs(ints);
        System.out.println(i);
    }
}
