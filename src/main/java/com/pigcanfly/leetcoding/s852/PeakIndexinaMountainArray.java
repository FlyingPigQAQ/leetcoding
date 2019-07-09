package com.pigcanfly.leetcoding.s852;

/**
 * TODO:二分搜索，三分搜索乃至黄金搜索https://leetcode.com/problems/peak-index-in-a-mountain-array/discuss/139848/C%2B%2BJavaPython-Better-than-Binary-Search
 * @author Tobby Quinn
 * @date 2019/07/03
 */
public class PeakIndexinaMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        for (int i = 1; i <A.length-1 ; i++) {
            if(A[i-1]<A[i] && A[i]>A[i+1]){
                return i;
            }
        }
        return 0;
    }
}
