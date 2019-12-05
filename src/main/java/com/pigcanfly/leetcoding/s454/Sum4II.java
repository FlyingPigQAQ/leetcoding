package com.pigcanfly.leetcoding.s454;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author tobbyquinn
 * @date 2019/10/31
 */
public class Sum4II {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                int tmp = a+b;
                map.put(tmp,map.getOrDefault(tmp,0)+1);
            }
        }
        int res=0;
        for (int c : C) {
            for (int d : D) {
                int tmp=c+d;
                int key = 0-tmp;
                if(map.containsKey(key)){
                    res+=map.get(key);
                }
            }
        }
        return res;
    }
}
