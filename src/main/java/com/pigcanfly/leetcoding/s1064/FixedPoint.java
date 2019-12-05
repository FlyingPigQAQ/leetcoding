package com.pigcanfly.leetcoding.s1064;

/**
 * @author tobbyquinn
 * @date 2019/11/29
 */
public class FixedPoint {
    public int fixedPoint(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if(A[i]==i){
                return i;
            }
        }
        return -1;
    }
}
