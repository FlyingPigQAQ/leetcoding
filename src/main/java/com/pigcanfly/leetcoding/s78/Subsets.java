package com.pigcanfly.leetcoding.s78;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 问题考虑：需要考虑 空集合[] 也属于集合的子集
 * 算法1
 * 首先添加空子集    []
 * cosidering  1  [1]                result:[1],[]
 * considering 2  [2,1] [2]          result:[1],[2,1],[2],[]
 * considering 3  [3,1] [3,2,1] [3,2] [3] result: [1],[2,1],[2],[3,1],[3,2,1],[3,2],[3]
 *
 * @author Tobby Quinn
 * @date 2019/06/17
 */
public class Subsets {
    //    public List<List<Integer>> subsets(int[] nums) {
//        ArrayList<List<Integer>> result = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//
//            for (int j = i; j < nums.length; j++) {
//                ArrayList<Integer> ints = new ArrayList<>();
//                if (j != i) {
//                    List<Integer> lasts = result.get(i * nums.length + j-1);
//                    lasts.add(nums[j]);
//                    ints.addAll(lasts);
//                }else {
//                    ints.add(nums[j]);
//                }
//                result.add(i * nums.length + j, ints);
//
//            }
//        }
//        return result;
//    }
    public List<List<Integer>> subsets1(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList());
        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            int lastResultSize = result.size();
            for (int j = 0; j < lastResultSize; j++) {
                List<Integer> lasts = result.get(j);
                ArrayList<Integer> ints = new ArrayList<>(lasts);
                ints.add(currentNumber);
                result.add(ints);
            }
        }
        return result;
    }
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        int n = nums.length, p = 1 << n;
        for (int i = 0; i < p; i++) {
            result.add(new ArrayList<Integer>());
            for (int j = 0; j < n; j++) {
                if ((((i >> j) & 1))==1) {
                    result.get(i).add(nums[j]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Subsets obj = new Subsets();
        List<List<Integer>> subsets = obj.subsets(new int[]{1, 2, 3});

        System.out.println((byte)1<<8);
    }
}
