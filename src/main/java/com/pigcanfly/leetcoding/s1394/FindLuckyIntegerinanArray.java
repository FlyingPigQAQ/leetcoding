package com.pigcanfly.leetcoding.s1394;

/**
 * @author tobbyquinn
 * @date 2020/04/28
 */
public class FindLuckyIntegerinanArray {
    public int findLucky(int[] arr) {
        int[] dict = new int[501];
        for (int a : arr) {
            dict[a]++;
        }
        for (int i = dict.length - 1; i >= 1; i--) {
            if (dict[i] == i) {
                return i;
            }
        }
        return -1;
    }
}
