package com.pigcanfly.leetcoding.s506;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author tobbyquinn
 * @date 2019/11/23
 */
public class RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < copy.length; i++) {
            map.put(copy[i],copy.length-i);
        }
        String[] res = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            Integer rank = map.get(nums[i]);
            switch (rank){
                case 1:
                    res[i]="Gold Medal";
                    break;
                case 2:
                    res[i]="Silver Medal";
                    break;
                case 3:
                    res[i]="Bronze Medal";
                    break;
                default:
                    res[i]=""+rank;
            }
        }
        return res;
    }
}
