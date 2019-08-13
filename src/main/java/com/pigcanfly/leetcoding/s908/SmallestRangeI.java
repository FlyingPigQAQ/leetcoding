package com.pigcanfly.leetcoding.s908;

import java.util.Arrays;

/**
 * @author Tobby Quinn
 * @date 2019/08/09
 */
public class SmallestRangeI {
    public int smallestRangeI(int[] A, int K) {
        Arrays.sort(A);
        int diff = A[A.length - 1] - A[0];
        return Math.max(diff-2*K,0);
    }
}
