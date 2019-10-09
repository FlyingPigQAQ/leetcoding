package com.pigcanfly.leetcoding.s485;

/**
 * @author tobbyquinn
 * @date 2019/10/04
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 1) {
            if (nums[0] == 1) {
                return 1;
            } else {
                return 0;
            }
        }
        int max = 0;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = Math.max(tmp, max);
                tmp = 0;
                continue;
            }
            tmp++;

        }
        return Math.max(max, tmp);
    }
}
