package com.pigcanfly.leetcoding.s27;

/**
 * @author Tobby Quinn
 * @date 2019/06/17
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int insertPos=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=val){
                nums[insertPos]=nums[i];
                insertPos++;
            }
        }
        return insertPos;

    }

    public static void main(String[] args) {
        RemoveElement obj = new RemoveElement();
    }
}
