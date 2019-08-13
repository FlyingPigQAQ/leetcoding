package com.pigcanfly.leetcoding.s70;

/**
 * TODO：经典问题
 *
 * @author Tobby Quinn
 * @date 2019/07/15
 */
public class ClimbingStairs {
    public int climbStairs1(int n) {
        return climbStairs1(0, n);
    }

    public int climbStairs1(int i, int n) {
        if(i>n){
            return 0;
        }
        if(i==n){
            return 1;
        }
        return climbStairs1(i+1,n)+climbStairs1(i+2,n);
    }

    public int climbStairs(int n) {
        int[] memo = new int[n];
        return climbStairs(0, n,memo);
    }

    public int climbStairs(int i, int n,int[] memo) {
        if(i>n){
            return 0;
        }
        if(i==n){
            return 1;
        }
        if(memo[i]>0){
            return memo[i];
        }

        memo[i]=climbStairs(i+1,n,memo)+climbStairs(i+2,n,memo);
        return memo[i];
    }

}
