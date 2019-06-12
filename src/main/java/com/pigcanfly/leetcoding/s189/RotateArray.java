package com.pigcanfly.leetcoding.s189;

/**
 * @author Tobby Quinn
 * @date 2019/06/11
 */
public class RotateArray {
    /**
     * 时间复杂度O(N) 常数为2
     * 空间复杂度O(N) 常数为1
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int insIndex = (i + k) % nums.length;
            temp[insIndex]=nums[i];
        }

        for (int i = 0; i < temp.length; i++) {
            nums[i]=temp[i];
        }
    }
    //TODO:空间复杂度为O(1)算法

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        rotate(nums,3);
    }
}
