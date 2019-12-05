package com.pigcanfly.leetcoding.s121;

import java.util.Stack;

/**
 * @author tobbyquinn
 * @date 2019/10/18
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if(prices.length<2){
            return 0;
        }
        int[] res = new int[prices.length];
        res[0]=0;
        int min= prices[0],max=0;
        for (int i = 1; i <prices.length ; i++) {
            res[i]=prices[i]-min;
            max=Math.max(res[i],max);
            min=Math.min(prices[i],min);
        }
        return max;
    }
}
