package com.pigcanfly.leetcoding.s1184;

/**
 * @author tobbyquinn
 * @date 2019/09/08
 */
public class DistanceBetweenBusStops {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int  sumA=0,total=0;
        for (int i = 0; i < distance.length; i++) {
            total+=distance[i];
        }
        for (int i = start<destination?start:destination; i < (start<destination?destination:start); i++) {
            sumA+=distance[i];
        }
        return Math.min(sumA,total-sumA);

    }
}
