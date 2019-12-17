package com.pigcanfly.leetcoding.s198;

import java.util.HashMap;

/**
 * @author tobbyquinn
 * @date 2019/12/10
 */
public class HouseRobber {
    public int rob1(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        HashMap<Integer, Integer> cache = new HashMap<>();
        return Math.max(maxRob(nums,0,cache),maxRob(nums,1,cache));
    }
    public Integer maxRob(int[] nums,int index,HashMap<Integer,Integer> cache) {
        if(cache.containsKey(index)){
            return cache.get(index);
        }
        int max=nums[index];
        for (int i = index+2; i < nums.length; i++) {
            Integer subInteger = maxRob(nums, i, cache);
            cache.put(i,subInteger);
            max=Math.max(nums[index]+ subInteger,max);
        }
        return max;
    }

    /**
     * DP
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int first=0,second=0;
        for (int num : nums) {
            int tmp =second;
            second=Math.max(first+num,second);
            first=tmp;
        }
        return second;
    }

    public static void main(String[] args) {
        int[] arg={2,7,9,3,1};
        System.out.println(new HouseRobber().rob(arg));
    }
}
