package com.pigcanfly.leetcoding.s888;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * @author Tobby Quinn
 * @date 2019/08/27
 */
public class FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int aLen = A.length, bLen = B.length;
        HashMap<Integer, Integer> cache = new HashMap<>();
        int aSum = 0, bSum = 0,average=0;
        for (int i = 0; i < aLen; i++) {
            aSum += A[i];
            cache.put(A[i], 1);
        }
        for (int i = 0; i < bLen; i++) {
            bSum += B[i];
        }
        average=(aSum+bSum)/2;
        for (int i = 0; i < bLen; i++) {
            int bi = B[i];
            int tmp = average-(bSum-bi);
            if(cache.containsKey(tmp) && aSum-tmp+bi==average){
                return new int[]{tmp,bi};
            }
        }
        return new int[0];

    }
}
