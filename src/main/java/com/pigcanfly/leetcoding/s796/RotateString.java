package com.pigcanfly.leetcoding.s796;

/**
 * TODO:https://leetcode.com/problems/rotate-string/solution/
 * @author Tobby Quinn
 * @date 2019/07/15
 */
public class RotateString {
    public boolean rotateString(String A, String B) {
        if(A.equals(B)){
            return true;
        }
        for (int i = 0; i < A.length()-1; i++) {
            String first = A.substring(0,i + 1);
            String last = A.substring(i + 1);
            if((last+first).equals(B)){
                return true;
            }


        }
        return false;
    }

    public static void main(String[] args) {
        String substring = "abc".substring(0,1);
        System.out.println(substring);
    }
}
