package com.pigcanfly.leetcoding.s1213;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tobbyquinn
 * @date 2019/11/27
 */
public class IntersectionofThreeSortedArrays {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int[] cache = new int[2001];
        for (int i : arr1) {
            cache[i]++;
        }
        for (int i : arr2) {
            cache[i]++;
        }
        for (int i : arr3) {
            cache[i]++;
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < cache.length; i++) {
            if(cache[i]>=3){
                res.add(i);
            }
        }
        return res;
    }
}
