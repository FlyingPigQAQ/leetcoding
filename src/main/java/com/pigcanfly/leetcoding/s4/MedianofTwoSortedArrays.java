package com.pigcanfly.leetcoding.s4;

import java.util.Arrays;

/**
 * TODO: 用其他方式思考
 * @author tobbyquinn
 * @date 2019/11/04
 */
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        System.arraycopy(nums1,0,arr,0,nums1.length);
        System.arraycopy(nums2,0,arr,nums1.length,nums2.length);
        Arrays.sort(arr);
        int aver=arr.length/2;
        if(arr.length%2==0){
            return ((double) arr[aver]+(double) arr[aver-1])/2;
        }else {
            return arr[aver];
        }
    }
}
