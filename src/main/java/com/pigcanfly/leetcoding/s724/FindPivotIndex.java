package com.pigcanfly.leetcoding.s724;

/**
 * 题设条件感觉不好，为什么索引0，默认左边之和为0呢，而不是其他数字
 * @author tobbyquinn
 * @date 2020/02/03
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
       int sum=0,leftSum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        for (int i = 0; i < nums.length ; i++) {
            if(leftSum==sum-leftSum-nums[i]){
                return i;
            }
            leftSum+=nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
