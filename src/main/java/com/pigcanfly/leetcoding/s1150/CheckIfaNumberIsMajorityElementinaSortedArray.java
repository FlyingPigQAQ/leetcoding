package com.pigcanfly.leetcoding.s1150;

/**
 * @author tobbyquinn
 * @date 2019/12/05
 */
public class CheckIfaNumberIsMajorityElementinaSortedArray {
    public boolean isMajorityElement(int[] nums, int target) {
        if(nums[nums.length/2]!=target){
            return false;
        }
        int left=nums.length/2-1,right=left+2,res=1;
        while (left>=0 || right<=nums.length-1){
            if(left>=0 && nums[left]==target){
                res++;
                left--;
            }else if(right<=nums.length-1 &&nums[right]==target){
                res++;
                right++;
            }else {
                break;
            }
        }
        return res>nums.length/2;
    }
}
