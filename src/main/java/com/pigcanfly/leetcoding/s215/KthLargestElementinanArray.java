package com.pigcanfly.leetcoding.s215;

import java.util.Arrays;

/**
 * @author tobbyquinn
 * @date 2019/11/29
 */
public class KthLargestElementinanArray {
    /**
     * 方法一：排序遍历
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    /**
     * TODO: 方法二：快排 QuickSelect
     */
}
