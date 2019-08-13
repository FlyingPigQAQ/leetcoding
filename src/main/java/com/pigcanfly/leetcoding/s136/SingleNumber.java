package com.pigcanfly.leetcoding.s136;

import java.util.Arrays;

/**
 * TODO:经典问题
 * @author Tobby Quinn
 * @date 2019/07/15
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length ; i+=2) {
            if(i==nums.length-1 || nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
        return 0;
    }
}
