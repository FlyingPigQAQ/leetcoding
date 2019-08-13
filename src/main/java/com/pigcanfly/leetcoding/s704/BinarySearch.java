package com.pigcanfly.leetcoding.s704;

/**
 * @author Tobby Quinn
 * @date 2019/07/18
 */
public class BinarySearch {
    /**
     * O(n解法)
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }

    /**
     * 二分搜索
     * O(log(N))
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int len = nums.length,left=0,right=len-1,mid;

        while(left<=right){
            mid=(right+left)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }

}
