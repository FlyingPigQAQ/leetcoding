package com.pigcanfly.leetcoding.s338;

/**
 * TODO: bitCount
 * @author tobbyquinn
 * @date 2019/10/15
 */
public class CountingBits {
    /**
     * Integer bitCount
     * @param num
     * @return
     */
    public int[] countBits1(int num) {
        int[] res =  new int[num+1];
        for(int i=0;i<=num;i++){
            res[i]=bitCount(i);
        }
        return res;
    }

    public  int bitCount(int i) {
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
    }

    /**
     * DP Solution
     * res[i>>1] 查询 已经计算出来的i/2位置上的1的数量
     * +
     * i&1 计算最后一位是不是1
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <=num; i++) {
            res[i]=res[i>>1]+(i&1);
        }
        return res;
    }
}
