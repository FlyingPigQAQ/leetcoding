package com.pigcanfly.leetcoding.s1266;

/**
 * @author tobbyquinn
 * @date 2019/11/28
 */
public class MinimumTimeVisitingAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int cost = 0;
        for (int i = 1; i < points.length; i++) {
            int lastX = points[i - 1][0], lastY = points[i - 1][1];
            int x = points[i][0], y = points[i][1];
            if (x != lastX && y != lastY) {
                int xDiff=Math.abs(x-lastX),yDiff=Math.abs(y-lastY),min=Math.min(xDiff,yDiff);
                cost+=min+(xDiff-min)+(yDiff-min);
            } else if (x == lastX && y != lastY) {
                cost += Math.abs(y - lastY);
            } else if (x != lastX) {
                cost += Math.abs(x - lastX);
            }
        }
        return cost;
    }
}
