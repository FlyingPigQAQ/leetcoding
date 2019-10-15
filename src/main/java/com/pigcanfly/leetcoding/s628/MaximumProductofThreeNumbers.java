package com.pigcanfly.leetcoding.s628;

import java.util.Arrays;

/**
 * @author tobbyquinn
 * @date 2019/10/14
 */
public class MaximumProductofThreeNumbers {
    /**
     *O(NlogN)
     * @param nums
     * @return
     */
    public static int maximumProduct1(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[len - 1] * nums[len - 2] * nums[len - 3], nums[0] * nums[1] * nums[len - 1]);
    }

    /**
     * O(N)
     * @param nums
     * @return
     */
    public static int maximumProduct(int[] nums) {
        int min1=Integer.MAX_VALUE,min2=min1,max1=Integer.MIN_VALUE,max2=max1,max3=max1;
        for (int num : nums) {
            if(min1>num){
                min2=min1;
                min1=num;
            }else if(min2>num){
               min2=num;
            }
            if(max3<num){
                max1=max2;
                max2=max3;
                max3=num;
            }else if(max2<num){
                max1=max2;
                max2=num;
            }else if(max1<num){
                max1=num;
            }
        }
        return Math.max(max1 * max2*max3,max3*min1*min2);
    }

    public static void main(String[] args) {
        int[] arg = {-1,-2,-3};
        int i = maximumProduct(arg);
        System.out.println(i);
    }
}
