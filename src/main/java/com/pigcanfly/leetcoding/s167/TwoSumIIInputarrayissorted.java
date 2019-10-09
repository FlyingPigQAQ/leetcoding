package com.pigcanfly.leetcoding.s167;

/**
 * @author tobbyquinn
 * @date 2019/10/09
 */
public class TwoSumIIInputarrayissorted {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i+1; j <numbers.length ; j++) {
                int tmp = numbers[i]+numbers[j];
                if(tmp>target){
                    break;
                }
                if(tmp==target){
                    return new int[]{i+1,j+1};
                }
            }
        }
        return new int[0];
    }

    /**
     * Two points
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum1(int[] numbers, int target) {
       int l=0,r=numbers.length-1;
       while(l<r){
           int tmp=numbers[r]+numbers[l];
           if(tmp==target){
               return new int[]{l+1,r+1};
           }
           if(tmp<target){
               l++;
           }else {
               r--;
           }
       }
        return new int[0];
    }
}
