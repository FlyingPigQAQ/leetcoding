package com.pigcanfly.leetcoding.s137;

import java.util.Arrays;

/**
 * TODO: bit写法
 * @author tobbyquinn
 * @date 2019/12/30
 */
public class SingleNumberII {
    /**
     * O(NlogN)
     *
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 && nums[i] != nums[i + 1]) {
                return nums[i];
            } else if (i == nums.length - 1 && nums[i] != nums[i - 1]) {
                return nums[i];
            } else if (nums[i] != nums[i + 1] && nums[i] != nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * O(N)
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
       int appearanceOnce=0,appearanceTwice=0;
        for (int i = 0; i < nums.length; i++) {
            appearanceOnce=~appearanceTwice&(appearanceOnce^nums[i]);
            appearanceTwice=~appearanceOnce&(appearanceTwice^nums[i]);
        }
        return appearanceOnce;
    }
}
