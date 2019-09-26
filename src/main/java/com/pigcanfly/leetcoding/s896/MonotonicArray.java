package com.pigcanfly.leetcoding.s896;

/**
 * @author tobbyquinn
 * @date 2019/09/12
 */
public class MonotonicArray {
    public static boolean isMonotonic(int[] A) {
        if(A.length<3){
            return true;
        }
        boolean isAsc=false;
        boolean flag=false;
        for (int i = 0; i <A.length-1 ; i++) {
            if(A[i]==A[i+1]){
                continue;
            }
            if(!flag){
                isAsc=A[i]<A[i+1];
                flag=true;
                continue;
            }
            if(isAsc^(A[i]<A[i+1])){
                return false;
            }
        }
        return true;
    }

    public boolean isMonotonic1(int[] A) {
        boolean inc = true, dec = true;
        for (int i = 1; i < A.length; ++i) {
            inc &= A[i - 1] <= A[i];
            dec &= A[i - 1] >= A[i];
        }
        return inc || dec;
    }


}
