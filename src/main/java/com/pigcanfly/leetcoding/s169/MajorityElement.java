package com.pigcanfly.leetcoding.s169;

import java.util.HashMap;

/**
 * TODO:看解题思路 https://leetcode.com/problems/majority-element/solution/
 * @author tobbyquinn
 * @date 2019/09/26
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int max=nums.length/2;
        HashMap<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            cache.computeIfPresent(nums[i],(key,value)->{
                value++;
                return value;
            });
            cache.computeIfAbsent(nums[i],v->{
                return 1;
            });
            if(cache.get(nums[i])>max){
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
