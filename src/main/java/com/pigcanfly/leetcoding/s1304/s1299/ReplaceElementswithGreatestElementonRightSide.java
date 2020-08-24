package com.pigcanfly.leetcoding.s1304.s1299;

/**
 * @author tobbyquinn
 * @date 2019/12/30
 */
public class ReplaceElementswithGreatestElementonRightSide {
    public int[] replaceElements(int[] arr) {
        int lastMaxElement=arr[arr.length-1];
        arr[arr.length-1]=-1;
        for (int i = arr.length-2; i >=0; i--) {
            int tmp=arr[i];
            arr[i]=lastMaxElement;
            lastMaxElement=Math.max(lastMaxElement,tmp);
        }
        return arr;
    }
}
