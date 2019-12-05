package com.pigcanfly.leetcoding.s994;

/**
 * @author tobbyquinn
 * @date 2019/10/24
 */
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int totalRresh1=0,totalRotten=0,totalRefresh=0,minus=0,lastRemainedRefresh=-1;
        boolean firstIter=true;
        while (true) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if(firstIter){
                        if(grid[i][j]==3 || grid[i][j]==1){
                            totalRefresh++;
                            totalRresh1++;
                        }else if(grid[i][j]==2){
                            totalRotten++;
                        }
                    }
                    if(grid[i][j]==3){
                        grid[i][j]=2;
                        continue;
                    }
                    if (grid[i][j] == 2) {
                        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                            grid[i - 1][j] = 2;
                            totalRefresh--;
                        }
                        if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                            grid[i + 1][j] = 3;
                            totalRefresh--;
                        }
                        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                            grid[i][j - 1] = 2;
                            totalRefresh--;
                        }
                        if (j + 1 < grid[i].length && grid[i][j + 1] == 1) {
                            grid[i][j + 1] = 3;
                            totalRefresh--;
                        }
                    }
                }
            }
            minus++;
            firstIter=false;
            if(totalRresh1==0 ){
                return 0;
            }else if( totalRotten==0){
                return -1;
            }
            if(totalRefresh==lastRemainedRefresh ){
                if( totalRefresh==0){
                    return minus-1;
                }else {
                    return -1;
                }
            }else{
                lastRemainedRefresh=totalRefresh;
            }
        }
    }

    public static void main(String[] args) {
        int[][] ints ={{1,1,2,0,2,0}};
        int i = new RottingOranges().orangesRotting(ints);
        System.out.println(i);
    }
}
