package com.pigcanfly.leetcoding.s1413;

/**
 * @author tobbyquinn
 * @date 2020/05/20
 */
public class MinimumValuetoGetPositiveStepbyStepSum {
    public int minStartValue(int[] nums) {
        int res = 1, sum = 0;
        for (int num : nums) {
            if (num < 0) {
                res = Math.max(1 - sum - num, res);
            }
            sum += num;
        }
        return res;
    }
}
