package com.pigcanfly.leetcoding.s1534;

/**
 * @author tobbyquinn
 * @date 2020/08/11
 */
public class CountGoodTriplets {
    public int countGoodTriplets1(int[] arr, int a, int b, int c) {
        int total = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a
                            && Math.abs(arr[j] - arr[k]) <= b
                            && Math.abs(arr[i] - arr[k]) <= c) {
                        total++;
                    }
                }
            }
        }
        return total;
    }

    /**
     * 简单优化
     * @param arr
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int total = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (Math.abs(arr[i] - arr[j]) <= a){
                    for (int k = j + 1; k < arr.length; k++) {
                        if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                            total++;
                        }
                    }
                }
            }
        }
        return total;
    }
}
