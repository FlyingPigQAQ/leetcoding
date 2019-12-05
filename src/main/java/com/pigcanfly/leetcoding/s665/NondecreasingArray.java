package com.pigcanfly.leetcoding.s665;

import java.util.HashMap;

/**
 *  TODO ： 未做
 *  4 2 3   true
 *  4 2 1   false
 *  3 4 2 3 false
 *  3 3 2 2 false
 * @author tobbyquinn
 * @date 2019/10/25
 */
public class NondecreasingArray {
    public boolean checkPossibility(int[] nums) {
        if(nums.length<3){
            return true;
        }
        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i]=nums[i];
        }

        return true;
    }

    public static void main(String[] args) {
        new NondecreasingArray().checkPossibility(new int[]{3,4,2,3});
    }
}
