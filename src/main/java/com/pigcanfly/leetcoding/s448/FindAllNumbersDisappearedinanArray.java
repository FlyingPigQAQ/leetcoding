package com.pigcanfly.leetcoding.s448;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tobbyquinn
 * @date 2019/10/12
 */
public class FindAllNumbersDisappearedinanArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int index=0;
        while(index<nums.length){
            int curr=nums[index];
            if(curr==index+1){
                index++;
                continue;
            }
            if(nums[curr-1]!=curr){
                nums[index]=nums[curr-1];
                nums[curr-1]=curr;
            }else{
                index++;
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=i+1){
                res.add(i+1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new FindAllNumbersDisappearedinanArray().findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
    }
}
