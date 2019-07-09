package com.pigcanfly.leetcoding.s922;

/**
 * @author Tobby Quinn
 * @date 2019/07/06
 */
public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] A) {
        int odd = 1, even = 0;
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                res[even] = A[i];
                even += 2;
            } else {
                res[odd] = A[i];
                odd += 2;
            }
        }
        return res;

    }
}
