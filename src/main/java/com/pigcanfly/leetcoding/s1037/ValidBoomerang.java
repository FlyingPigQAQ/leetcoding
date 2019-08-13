package com.pigcanfly.leetcoding.s1037;

/**
 * @author Tobby Quinn
 * @date 2019/08/04
 */
public class ValidBoomerang {
    public boolean isBoomerang(int[][] points) {
        if(points[0][1]==points[1][0] ){
            return false;
        }
        if(isSame(points[0],points[1]) || isSame(points[0],points[2]) || isSame(points[1],points[2])){
            return false;
        }
        return true;
    }
    private boolean isSame(int[] r1,int[] r2){
        return r1[0]==r2[0] &&r1[1]==r2[1];
    }
}
