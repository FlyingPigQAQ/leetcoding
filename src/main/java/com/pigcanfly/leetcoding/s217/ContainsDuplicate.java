package com.pigcanfly.leetcoding.s217;

import java.util.HashMap;

/**
 * @author Tobby Quinn
 * @date 2019/06/19
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(cache.containsKey(nums[i])){
                return true;
            }
            cache.put(nums[i],1);
        }
        return false;
    }
}
