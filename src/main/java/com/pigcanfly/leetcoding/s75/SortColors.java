package com.pigcanfly.leetcoding.s75;

/**
 * @author tobbyquinn
 * @date 2019/11/01
 */
public class SortColors {
    public static void sortColors(int[] nums) {
        for (int i = 0, left = 0, right = nums.length - 1; i <= right; ) {
            if(nums[i]==0){
                if(i==left){
                    i++;
                    left++;
                }else{
                    nums[i]=nums[left];
                    nums[left]=0;
                    left++;
                }
            }else if(nums[i]==2){
                if(nums[right]==2){
                    right--;
                }else{
                    nums[i]=nums[right];
                    nums[right]=2;
                    right--;
                }
            }else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        sortColors(new int[]{2,0,1});
    }
}