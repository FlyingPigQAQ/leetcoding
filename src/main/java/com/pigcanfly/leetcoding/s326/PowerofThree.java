package com.pigcanfly.leetcoding.s326;

/**
 * @author tobbyquinn
 * @date 2019/10/09
 */
public class PowerofThree {
    public boolean isPowerOfThree(int n) {
       // return n>0 && Math.pow(3,19)%n==0;
        return n>0 && 1162261467%n==0;
    }

    public static void main(String[] args) {
        new PowerofThree().isPowerOfThree(729);
        System.out.println((int)Math.pow(3,19));
    }
}
