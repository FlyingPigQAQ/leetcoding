package com.pigcanfly.leetcoding.s1480;

/**
 * @author tobbyquinn
 * @date 2020/07/07
 */
public class RunningSumof1dArray {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
