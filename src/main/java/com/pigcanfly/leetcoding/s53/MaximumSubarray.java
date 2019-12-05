package com.pigcanfly.leetcoding.s53;

/**
 * @author tobbyquinn
 * @date 2019/10/18
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int[] res = new int[nums.length];
        res[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i]=Math.max(nums[i],res[i-1]+nums[i]);
        }
        int max=res[0];
        for (int re : res) {
            max=Math.max(re,max);
        }
        return max;
    }
}
