package com.pigcanfly.leetcoding.s944;

/**
 * @author tobbyquinn
 * @date 2020/01/13
 */
public class DeleteColumnstoMakeSorted {
    public int minDeletionSize(String[] A) {
        if (A.length == 1) {
            return 0;
        }
        int minimum = 0;
        for (int i = 0; i < A[0].length(); i++) {
            char c = A[0].charAt(i);
            for (int j = 1; j < A.length; j++) {
                if(A[j].charAt(i)<c){
                    minimum++;
                    break;
                }else {
                    c=A[j].charAt(i);
                }
            }
        }
        return minimum;
    }
}
