package com.pigcanfly.leetcoding.s1099;

/**
 * @author tobbyquinn
 * @date 2019/11/29
 */
public class TwoSumLessThanK {
    public int twoSumLessThanK(int[] A, int K) {
        int[] res=new int[2];
        for (int i = 0; i < A.length-1; i++) {
            if(A[i]>=K){
                continue;
            }
            for (int j = i+1; j < A.length; j++) {
                if(A[i]+A[j]<K && A[i]+A[j]>res[0]+res[1]){
                    res[0]=A[i];
                    res[1]=A[j];
                }
            }
        }
        return res[0]+res[1]==0?-1:res[0]+res[1];
    }
}
