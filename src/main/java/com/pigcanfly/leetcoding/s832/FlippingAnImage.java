package com.pigcanfly.leetcoding.s832;

/**
 * @author Tobby Quinn
 * @date 2019/06/27
 */
public class FlippingAnImage {
    public static int[][] flipAndInvertImage(int[][] A) {
        int aLength=A.length;
        for (int i = 0; i < aLength; i++) {
            int aILength=A[i].length;
            //reverse each row
            for (int j = 0; j < aILength/2; j++) {
                int last = A[i][aILength - 1 - j];
                A[i][aILength - 1 - j]=A[i][j];
                A[i][j]=last;
            }
            //invert image
            for (int j = 0; j < aILength; j++) {
                if(A[i][j]==0){
                    A[i][j]=1;
                }else{
                    A[i][j]=0;
                }
            }
        }
        return A;
    }

    //优化后 考虑中间值的翻转
    public static int[][] flipAndInvertImage2(int[][] A) {
        int aLength=A.length;
        for (int i = 0; i < aLength; i++) {
            int aILength=A[i].length;
            //reverse each row &&  //invert image
            for (int j = 0; j < (aILength+1)/2; j++) {
                int last = (A[i][aILength - 1 - j])^1;
                A[i][aILength - 1 - j]=(A[i][j])^1;
                A[i][j]=last;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1,1,0},{1,0,1},{0,0,0}};
        flipAndInvertImage2(a);
    }
}
