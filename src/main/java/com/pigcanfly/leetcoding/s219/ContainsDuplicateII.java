package com.pigcanfly.leetcoding.s219;

import java.util.HashMap;

/**
 * @author tobbyquinn
 * @date 2019/10/24
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (cache.containsKey(nums[i])) {
                if (i - cache.get(nums[i]) <= k) {
                    return true;
                }
            }
            cache.put(nums[i], i);
        }
        return false;
    }
}
