package com.pigcanfly.leetcoding.s1232;

/**
 * @author tobbyquinn
 * @date 2019/10/24
 */
public class CheckIfItIsaStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length<3){
            return true;
        }
        double angle=(double)(coordinates[1][1]-coordinates[0][1])/(double)(coordinates[1][0]-coordinates[0][0]);
        for (int i = 0; i < coordinates.length - 1; i++) {
            if(((double)(coordinates[i+1][1]-coordinates[i][1])/(double)(coordinates[i+1][0]-coordinates[i][0]))!=angle){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] ints= {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
        new CheckIfItIsaStraightLine().checkStraightLine(ints);
    }
}
