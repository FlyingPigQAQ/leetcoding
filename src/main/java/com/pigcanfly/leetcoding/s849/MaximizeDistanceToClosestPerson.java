package com.pigcanfly.leetcoding.s849;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Tobby Quinn
 * @date 2019/06/11
 */
public class MaximizeDistanceToClosestPerson {

    public static int maxDistToClosest(int[] seats) {
        HashMap<Integer, Integer> map = new HashMap<>();

        boolean continuousZero = false;
        int startPos = -1;

        for (int i = 0; i < seats.length; i++) {
            if(seats[i]==0){
                if(!continuousZero){
                    startPos=i;
                }
                //判断0位于数组最后
                if(i==seats.length-1){
                   map.put(i-startPos+1,1);
                }
                continuousZero=true;
            }
            if(seats[i]==1){
                if(continuousZero){
                    //判断0位于数组最前
                    if(startPos==0){
                        map.put(i,1);
                    }else{
                        int sizeOfZero=i-startPos;
                        int distance;
                        if(sizeOfZero!=1){
                            distance=sizeOfZero%2==0?sizeOfZero/2:sizeOfZero/2+1;
                        }else{
                            distance=1;
                        }
                        map.put(distance,1);

                    }
                    startPos=-1;
                    continuousZero=false;
                }

            }
        }
        return Collections.max(map.keySet());

    }
    //TODO:左右指针代表到各亲近点的距离
    public static int maxDistToClosest2(int[] seats) {
        int N = seats.length;
        int prev = -1, future = 0;
        int ans = 0;

        for (int i = 0; i < N; ++i) {
            if (seats[i] == 1) {
                prev = i;
            } else {
                while (future < N && seats[future] == 0 || future < i)
                    future++;

                int left = prev == -1 ? N : i - prev;
                int right = future == N ? N : future - i;
                ans = Math.max(ans, Math.min(left, right));
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        int i = maxDistToClosest2(new int[]{0,1,0,0,1});
        System.out.println(i);
    }
}
