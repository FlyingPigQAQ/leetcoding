package com.pigcanfly.leetcoding.s447;

import java.util.HashMap;

/**
 * @author tobbyquinn
 * @date 2019/10/14
 */
public class NumberofBoomerangs {
    /**
     * O(N3)
     * Time Limit Exceeded
     * @param points
     * @return
     */
    public int numberOfBoomerangs1(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        int res = 0;
        for (int[] p1 : points) {
            for (int[] p2 : points) {
                for (int[] p3 : points) {
                    if (p1==p2 || p2==p3 || p1==p3) {
                        continue;
                    }
                    if(getDistance(p1,p2)==getDistance(p1,p3)){
                        res++;
                    }
                }
            }
        }
        return res;
    }
    public int getDistance(int[] x,int[] y){
        int dx=x[0]-y[0];
        int dy=x[1]-y[1];
        return dx*dx+dy*dy;
    }

    /**
     * O(N2)
     * @param points
     * @return
     */
    public int numberOfBoomerangs(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        int res = 0;
        HashMap<Integer, Integer> cache = new HashMap<>(500);
        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if(p1==p2){
                    continue;
                }
                int distance = getDistance(p1, p2);
                cache.put(distance, cache.getOrDefault(distance,0)+1);
            }
            for (Integer value : cache.values()) {
                res+=value*(value-1);
            }
            cache.clear();
        }
        return res;
    }





    public static void main(String[] args) {
        int[][] arg = {{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        new NumberofBoomerangs().numberOfBoomerangs(arg);
    }
}
