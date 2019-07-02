package com.pigcanfly.leetcoding.s28;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Tobby Quinn
 * @date 2019/06/27
 */
public class ImplementstrStr {
    public static int strStr(String haystack, String needle) {
        if("".equals(needle)){
            return 0;
        }
        if(haystack.length()<needle.length()){
            return -1;
        }

        for (int i = 0; i < haystack.length(); i++) {
            int index=i;
            for (int j = 0,ii=i; j < needle.length() && haystack.charAt(ii) == needle.charAt(j); j++,ii++,index++) {
            }
            if(index-i==needle.length()){
                return i;
            }
            if(i==haystack.length()-needle.length()){
                break;
            }
        }
        return -1;
    }

    //TODO :elegant java solution https://leetcode.com/problems/implement-strstr/discuss/12807/Elegant-Java-solution

    public static void main(String[] args) {


        int i = strStr("mississippi", "issipi");
        System.out.println(i);
    }
}
