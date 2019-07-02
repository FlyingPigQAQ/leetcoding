package com.pigcanfly.leetcoding.s1089;

import java.util.Arrays;

/**
 * @author Tobby Quinn
 * @date 2019/06/27
 */
public class DuplicateZeros {
    public static int[] duplicateZeros(int[] arr) {
        int startPos=0,endPos=arr.length-1;
        while (startPos<endPos){
            if(arr[startPos++]==0){
                endPos--;
            }
        }
        int[] copy = Arrays.copyOf(arr,  endPos+1);
        for (int i = 0,j=0; i < copy.length; i++) {
            if(copy[i]==0 && j<=arr.length-2){
                arr[j++]=0;
            }
            arr[j++]=copy[i];
        }
        return arr;
    }
    //TODO:用空间复杂度O(1)实现
    public static int[] duplicateZeros1(int[] arr) {
//        int startPos=0,endPos=arr.length-1,zeroShowTimes=0;
//        //统计0出现的次数
//        while (startPos<=endPos){
//            if(arr[startPos++]==0){
//                zeroShowTimes++;
//            }
//        }
//        for (int read = 0,write=0; read < endPos; read++) {
//            if(arr[read]==0){
//                w
//            }
//        }
        return arr;
    }

    public static void main(String[] args) {
        int[] ints = duplicateZeros(new int[]{8,4,5,0,0,0,0,7});
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+",");
        }
    }
}
