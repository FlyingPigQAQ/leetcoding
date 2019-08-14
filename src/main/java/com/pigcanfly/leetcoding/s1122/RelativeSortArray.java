package com.pigcanfly.leetcoding.s1122;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * @author Tobby Quinn
 * @date 2019/08/13
 */
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if(arr2.length==0){
            Arrays.sort(arr1);
            return arr1;
        }
        HashMap<Integer, Integer> dict = new HashMap<>();
        for (int num:arr1){
            if(dict.containsKey(num)){
                dict.put(num,dict.get(num)+1);
            }else{
                dict.put(num,1);
            }
        }
        int[] res = new int[arr1.length];
        int index=0;
        for (int num :arr2){
            for (int i = 0; i < dict.get(num); i++) {
                res[index++]=num;
            }
            dict.remove(num);
        }
        Integer[] nonRelative = new Integer[dict.size()];
        dict.keySet().toArray(nonRelative);
        Arrays.sort(nonRelative);
        for (int key:nonRelative){
            for (int i = 0; i < dict.get(key); i++) {
                res[index++]=key;
            }
        }
        return res;
    }

    /**
     * Good Job!
     * TODO：范围限定的前提，可以通过创建数组作为解题思路，不需要而外进行排序
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        int k = 0;
        int[] cnt = new int[1001], ans = new int[arr1.length];
        for (int i : arr1)                      // Count each number in arr1.
            ++cnt[i];
        for (int i : arr2)                      // Sort the common numbers in both arrays by the order of arr2.
            while (cnt[i]-- > 0)
                ans[k++] = i;
        for (int i = 0; i < 1001; ++i)          // Sort the numbers only in arr1.
            while (cnt[i]-- > 0)
                ans[k++] = i;
        return ans;
    }
}
