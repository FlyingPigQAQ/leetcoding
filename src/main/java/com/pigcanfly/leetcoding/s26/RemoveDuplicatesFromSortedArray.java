package com.pigcanfly.leetcoding.s26;

/**
 * TODO:复习 双指针解决
 * @author Tobby Quinn
 * @date 2019/06/17
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
       int insertPos=0;
        for (int i = 1; i < nums.length; i++) {
           if(nums[i]!=nums[insertPos]){
               insertPos++;
               nums[insertPos]=nums[i];
           }
        }
        return insertPos+1;
    }



    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();
        int i = obj.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
        System.out.println(i);

    }
}
