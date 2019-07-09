package com.pigcanfly.leetcoding.s1051;

import java.util.Arrays;

/**
 *
 * TODO；不使用排序的一种解决方式 https://leetcode.com/problems/height-checker/discuss/300472/Java-0ms-O(n)-solution-no-need-to-sort
 * @author Tobby Quinn
 * @date 2019/07/03
 */
public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] newInt = Arrays.copyOf(heights, heights.length);
        Arrays.sort(newInt);
        int res=0,n=heights.length;
        for (int i = 0; i < n; i++) {
            if(newInt[i]!=heights[i]){
                res++;
            }
        }
        return res;
    }
}
