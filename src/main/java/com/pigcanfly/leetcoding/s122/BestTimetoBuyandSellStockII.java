package com.pigcanfly.leetcoding.s122;

/**
 * TODO :画个股票折线图 ，所有的上涨曲线加起来 就是最大收益
 * @author tobbyquinn
 * @date 2019/10/18
 */
public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        if(prices.length<2){
            return 0;
        }
        int maxProfit=0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i]>prices[i-1]){
                maxProfit+=prices[i]-prices[i-1];
            }
        }
        return maxProfit;
    }
}
