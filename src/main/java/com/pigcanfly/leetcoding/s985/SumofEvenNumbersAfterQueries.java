package com.pigcanfly.leetcoding.s985;

/**
 * @author Tobby Quinn
 * @date 2019/08/09
 */
public class SumofEvenNumbersAfterQueries {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int aLen=A.length,qLen=queries.length;
        int[] res = new int[qLen];
        for (int i = 0; i < qLen; i++) {
            int sum=0;
            A[queries[i][1]]+=queries[i][0];
            for (int j = 0; j < aLen; j++) {
                if(A[j]%2==0){
                    sum+=A[j];
                }
            }
            res[i]=sum;
        }
        return res;
    }
}
