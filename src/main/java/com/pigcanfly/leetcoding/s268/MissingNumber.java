package com.pigcanfly.leetcoding.s268;

import java.util.Arrays;

/**
 * TODO:经典
 * 高斯 n(n+1)/2
 * @author Tobby Quinn
 * @date 2019/07/05
 */
public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int expectedTotal=nums.length*(nums.length+1)/2;
        return expectedTotal - Arrays.stream(nums).sum();
    }

    /**
     * Bit Manipulation
     * @param nums
     */
    public static int missingNumber1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            n ^=(i^nums[i]);
        }
        return n;
    }

    public static void main(String[] args) {
        missingNumber(new int[]{0,1,3});
    }
}
