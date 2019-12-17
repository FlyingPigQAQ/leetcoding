package com.pigcanfly.leetcoding.s598;

/**
 * @author tobbyquinn
 * @date 2019/12/12
 */
public class RangeAdditionII {
    public int maxCount(int m, int n, int[][] ops) {
        //这个临界点，如果操作组ops为空，最大的应为m*n
        if(ops.length==0){
            return m*n;
        }
        int crossX=ops[0][0],crossY=ops[0][1];
        for (int i = 1; i < ops.length; i++) {
            crossX=Math.min(ops[i][0],crossX);
            crossY=Math.min(ops[i][1],crossY);
        }
        return crossX*crossY;
    }
}
