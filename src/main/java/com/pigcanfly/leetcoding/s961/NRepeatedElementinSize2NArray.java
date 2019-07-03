package com.pigcanfly.leetcoding.s961;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Tobby Quinn
 * @date 2019/07/02
 */
public class NRepeatedElementinSize2NArray {
    public static int repeatedNTimes(int[] A) {
       Arrays.sort(A);
        for (int i = 0; i <= A.length - 2; i++) {
            if(A[i]==A[i+1]){
                return A[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        repeatedNTimes(new int[]{1,2,3,3});
    }

}
