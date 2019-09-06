package com.pigcanfly.sort;

/**
 * @author tobbyquinn
 * @date 2019/09/04
 */
public class InsertionSort {
    public static int[] sort(int args[]) {
        if(args.length<2){
            return args;
        }
        for (int i = 1; i < args.length; i++) {
            int j=i;
            while(j>=1 &&args[j]<args[j-1]){
                int temp = args[j];
                args[j]=args[j-1];
                args[j-1]=temp;
                j--;
            }
        }
        return args;
    }
}
