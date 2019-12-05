package com.pigcanfly.leetcoding.s1198;

import com.pigcanfly.leetcoding.s744.FindSmallestLetterGreaterThanTarget;

import java.util.ArrayList;

/**
 * @author tobbyquinn
 * @date 2019/12/04
 */
public class FindSmallestCommonElementinAllRows {
    public int smallestCommonElement(int[][] mat) {
        if(mat.length==1){
            return mat[0][0];
        }
        ArrayList<Integer> common = new ArrayList<>();
        for (int i = 0,j=0; i < mat[0].length&&j<mat[1].length;) {
            if(mat[0][i]==mat[1][j]){
                common.add(mat[0][i]);
                i++;
                j++;
            }else if(mat[0][i]<mat[1][j]){
                i++;
            }else {
                j++;
            }
        }
        for (int i = 0; i < common.size(); i++) {
            Integer target = common.get(i);
            boolean isBreak=false;
            for (int j = 2; j < mat.length; j++) {
                if(!binarySearch(mat[j],target)){
                    isBreak=true;
                    break;
                }
            }
            if(!isBreak){
                return target;
            }
        }
        return -1;
    }
    boolean binarySearch(int[] arr,int target){
        int low=0,high=arr.length-1;
        while (low<=high){
            int mid=low+((high-low)>>1);
            if(arr[mid]==target){
                return true;
            }else if(arr[mid]>target){
                high=mid-1;
            }else {
                low=mid+1;
            }
        }
        return false;
    }


}
