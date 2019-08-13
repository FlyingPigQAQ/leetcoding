package com.pigcanfly.leetcoding.s821;

/**
 * TODO：O(N)复杂度
 * @author Tobby Quinn
 * @date 2019/08/05
 */
public class ShortestDistancetoaCharacter {
    public static  int[] shortestToChar(String S, char C) {
        int len = S.length(),prev=Integer.MIN_VALUE/2,last=Integer.MAX_VALUE/2;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            if(S.charAt(i)==C){
                prev=i;
            }
            res[i]=i-prev;
        }
        for (int i = len-1; i >= 0; i--) {
            if(S.charAt(i)==C){
                last=i;
            }
            res[i]=Math.min(last-i,res[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        shortestToChar(
                "loveleetcode", 'e');
    }
}
