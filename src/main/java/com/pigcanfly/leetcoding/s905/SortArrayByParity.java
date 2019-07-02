package com.pigcanfly.leetcoding.s905;

/**
 * @author Tobby Quinn
 * @date 2019/07/01
 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int len=A.length,startPos=0,endPos=len-1;
        while(startPos<endPos){
            if(A[startPos]%2==1 && A[endPos]%2==0){
                int tmp= A[endPos];
                A[endPos]=A[startPos];
                A[startPos]=tmp;
                startPos++;
                endPos--;
                continue;
            }
            if(A[startPos]%2==0 ){
                startPos++;
            }
            if(A[endPos]%2==1 ){
                endPos--;
            }

        }
        return A;

    }
}
