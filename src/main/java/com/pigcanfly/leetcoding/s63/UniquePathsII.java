package com.pigcanfly.leetcoding.s63;

import java.util.HashMap;

/**
 * TODO： DP
 * @author tobbyquinn
 * @date 2019/11/04
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        return uniquePathsWithObstacles(obstacleGrid,0,0,cache);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid,int i,int j,HashMap<Integer,Integer> cache) {
        if( i>=obstacleGrid.length || j>=obstacleGrid[0].length || obstacleGrid[i][j]==1 ){
            return 0;
        }
        if(i==obstacleGrid.length-1 && j==obstacleGrid[0].length-1){
            return 1;
        }
        if(cache.containsKey(i*1000+j)){
            return cache.get(i*1000+j);
        }
        cache.put(i*1000+j,uniquePathsWithObstacles(obstacleGrid,i+1,j,cache)
                +uniquePathsWithObstacles(obstacleGrid,i,j+1,cache));
        return cache.get(i*1000+j);
    }
}
