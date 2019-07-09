package com.pigcanfly.leetcoding.s268;

import java.util.Arrays;

/**
 * @author Tobby Quinn
 * @date 2019/07/05
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]!=nums[i+1]-1){
                return nums[i+1]-1;
            }
        }
        return 0;
    }
}
