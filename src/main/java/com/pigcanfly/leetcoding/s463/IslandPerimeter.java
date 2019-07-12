package com.pigcanfly.leetcoding.s463;

/**
 *
 * 如果都陆地都不相邻的话 那么周长为 4n
 * 如果陆地增加一个相邻陆地 则周长减少2
 * 那么最终的周长等于 陆地数*4-相邻陆地数*2
 * @author Tobby Quinn
 * @date 2019/07/12
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int island=0,neighbor=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1){
                    island++;
                    //count down
                    if(i<grid.length-1 &&grid[i+1][j]==1){neighbor++;}
                    //count right
                    if(j<grid[i].length-1  && grid[i][j+1]==1){neighbor++;}
                }
            }
        }
        return island*4-neighbor*2;
    }
}
