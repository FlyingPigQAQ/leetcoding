package com.pigcanfly.leetcoding.s976;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author tobbyquinn
 * @date 2019/10/15
 */
public class LargestPerimeterTriangle {
    /**
     * O(N3) Time Limit
     * @param A
     * @return
     */
    public int largestPerimeter1(int[] A) {
        int res=0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                for (int z = 0; z < A.length; z++) {
                    if(i==j || j==z ||i==z){
                        continue;
                    }
                    if(A[i]+A[j]>A[z] && A[i]+A[z]>A[j] && A[z]+A[j]>A[i]){
                        res=Math.max(res,A[i]+A[j]+A[z]);
                    }
                }
            }
        }
        return res;
    }

    /**
     * O(NlogN) TODO：思维局限。。。
     * @param A
     * @return
     */
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length-3; i >=0; i--) {
            if(A[i]+A[i+1]>A[i+2]){
                return A[i]+A[i+1]+A[i+2];
            }
        }
        return 0;
    }
}
