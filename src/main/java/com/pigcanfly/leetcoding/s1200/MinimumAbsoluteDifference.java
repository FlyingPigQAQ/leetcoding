package com.pigcanfly.leetcoding.s1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tobbyquinn
 * @date 2019/10/04
 */
public class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        if (arr.length == 1) {
            return new ArrayList();
        }
        Arrays.sort(arr);
        int min = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i] - arr[i - 1]);
        }
        List<List<Integer>> res = new ArrayList();
        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] - arr[i - 1]) == min) {
                res.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        return res;

    }
}
