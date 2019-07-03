package com.pigcanfly.leetcoding.s977;

/**
 * TODO:Two points
 * @author Tobby Quinn
 * @date 2019/07/02
 */
public class SquaresofaSortedArray {
    public int[] sortedSquares(int[] A) {
        for (int j = A.length-1; j >0; j--) {
            for (int i = 0; i < j; i++) {
                if(A[i]<0){
                    A[i]=-A[i];
                }
                if(A[i]>A[i+1]){
                    int tmp = A[i+1];
                    A[i+1]=A[i];
                    A[i]=tmp;
                }
                if(i==j-1){
                    A[j]=(int)Math.pow(A[j],2);
                }

            }
        }
        A[0]=(int)Math.pow(A[0],2);
        return A;


    }

    public static  int[] sortedSquares1(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        int i = 0, j = n - 1;
        for (int p = n - 1; p >= 0; p--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                result[p] = A[i] * A[i];
                i++;
            } else {
                result[p] = A[j] * A[j];
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        sortedSquares1(new int[]{-4,-1,0,3,10});
    }
}
