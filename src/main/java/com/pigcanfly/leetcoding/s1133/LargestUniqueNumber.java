package com.pigcanfly.leetcoding.s1133;

/**
 * @author tobbyquinn
 * @date 2019/11/28
 */
public class LargestUniqueNumber {
    public int largestUniqueNumber(int[] A) {
        int[] ints = new int[1001];
        for (int i : A) {
            ints[i]++;
        }
        for (int i = ints.length-1; i >=0; i--) {
            if(ints[i]==1){
                return i;
            }
        }
        return -1;
    }
}
