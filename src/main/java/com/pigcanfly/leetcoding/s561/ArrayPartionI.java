package com.pigcanfly.leetcoding.s561;

import java.util.Arrays;

/**
 * @author Tobby Quinn
 * @date 2019/06/29
 */
public class ArrayPartionI {

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += Math.min(nums[i], nums[i + 1]);
        }
        return sum;
    }

    public static void main(String[] args) {
//        int[] ints = {1, 3, 2, 4};
//        Arrays.sort(ints);
//        for (int i = 0; i < ints.length; i++) {
//            System.out.println(ints[i]);
//        }

        int i = arrayPairSum(new int[]{1, 4, 3, 2});
        System.out.println(i);
    }
}
