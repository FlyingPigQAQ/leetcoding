package com.pigcanfly.leetcoding.s1029;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author tobbyquinn
 * @date 2019/08/29
 */
public class TwoCityScheduling {
    public static int twoCitySchedCost(int[][] costs) {
        if(costs.length==0){
            return 0;
        }
        Arrays.sort(costs, (o1, o2) -> {
            if((o1[0]-o1[1])<(o2[0]-o2[1])){
                return -1;
            }else if((o1[0]-o1[1])>(o2[0]-o2[1])){
                return 1;
            }
            return 0;
        });
        int sumA=0,sumB=0;
        for (int i = 0; i <costs.length/2 ; i++) {
            sumA+=costs[i][0];
            sumB+=costs[i+costs.length/2][1];
        }
        return sumA+sumB;
    }
    public static int twoCitySchedCost1(int[][] costs) {
        int N = costs.length / 2;
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] + costs[i - 1][0];
        }
        for (int j = 1; j <= N; j++) {
            dp[0][j] = dp[0][j - 1] + costs[j - 1][1];
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + costs[i + j - 1][0], dp[i][j - 1] + costs[i + j - 1][1]);
            }
        }
        return dp[N][N];
    }

    public static void main(String[] args) {
        int[][] arg={{10,60},{30,200},{400,50},{30,50}};
        twoCitySchedCost(arg);
    }
}
