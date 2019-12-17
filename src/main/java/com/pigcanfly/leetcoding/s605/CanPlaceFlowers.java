package com.pigcanfly.leetcoding.s605;

/**
 * @author tobbyquinn
 * @date 2019/12/17
 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers1(int[] flowerbed, int n) {
        int prePlaced=-2;
        for (int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i]==1){
                prePlaced=i;
                continue;
            }
            if(i-prePlaced>1   && (i==flowerbed.length-1 || flowerbed[i+1]==0 )){
                prePlaced=i;
                n--;
            }
        }
        return n<=0;
    }

    /**
     * 可选优化，提前终止
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int prePlaced=-2;
        for (int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i]==1){
                prePlaced=i;
                continue;
            }
            if(i-prePlaced>1   && (i==flowerbed.length-1 || flowerbed[i+1]==0 )){
                prePlaced=i;
                n--;
            }
            if(n<=0){
                return true;
            }
        }
        return n<=0;
    }
}
