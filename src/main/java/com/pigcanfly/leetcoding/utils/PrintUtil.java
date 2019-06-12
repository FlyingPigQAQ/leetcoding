package com.pigcanfly.leetcoding.utils;

/**
 * @author Tobby Quinn
 * @date 2019/06/11
 */
public class PrintUtil {


    public static void iteratorInteger(int[] ints){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < ints.length; i++) {
           sb.append(ints[i]);
           if(i!=ints.length-1){
               sb.append(",");
           }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
