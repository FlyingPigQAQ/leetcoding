package com.pigcanfly.leetcoding.s1196;

import java.util.Arrays;

/**
 * @author tobbyquinn
 * @date 2019/12/02
 */
public class HowManyApplesCanYouPutintotheBasket {
    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int index=0,sum=0;
        while (index<arr.length){
            sum+=arr[index];
            if(sum>5000){
                return index;
            }
            index++;
        }
        return arr.length;
    }
}
