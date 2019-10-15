package com.pigcanfly.leetcoding.s812;

/**
 * @author tobbyquinn
 * @date 2019/10/12
 */
public class LargestTriangleArea {

    public double largestTriangleArea(int[][] points) {
        double area=0;
        for (int[] point0 : points) {  //x0,y0
            for (int[] point1 : points) { //x1,y1
                for (int[] point2 : points) { //x2,y2
                    area=Math.max(area,0.5*(point0[1]-point1[1])*(point1[0]-point0[0])+
                            0.5*(point0[1]-point1[1])*(point0[0]-point2[0])+
                            0.5*(point1[0]-point0[0])*(point1[1]-point2[1]));
                }
            }
        }
        return area;
    }
}
