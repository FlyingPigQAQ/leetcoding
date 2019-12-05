package com.pigcanfly.leetcoding.s1243;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author tobbyquinn
 * @date 2019/12/03
 */
public class ArrayTransformation {
    public List<Integer> transformArray(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        if(arr.length<3){
            for (int i = 0; i < arr.length; i++) {
                res.add(arr[i]);
            }
            return res;
        }
        int[] newArr=new int[arr.length];
        //设置头尾
        newArr[0]=arr[0];
        newArr[arr.length-1]=arr[arr.length-1];
        while (true){
            int allIn=0;
            for (int i = 1; i <= arr.length-2; i++) {
                if(arr[i-1]<arr[i] && arr[i+1]<arr[i]){
                    newArr[i]=arr[i]-1;
                }else if(arr[i-1]>arr[i] && arr[i+1]>arr[i]){
                    newArr[i]=arr[i]+1;
                }else {
                    newArr[i]=arr[i];
                    allIn++;
                }
            }
            if(allIn==arr.length-2){
                break;
            }else {
                int[] tmp = arr;
                arr=newArr;
                newArr=tmp;
            }
        }
        for (int i = 0; i < newArr.length; i++) {
            res.add(newArr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arg={1,5,4,7,9,2,5,1,2,5,8,8,3,8,4,4,6,3};
        new ArrayTransformation().transformArray(arg);

    }
}
