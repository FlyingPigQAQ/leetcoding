package com.pigcanfly.leetcoding.s344;

/**
 * @author Tobby Quinn
 * @date 2019/07/04
 */
public class ReverseString {

    public void reverseString(char[] s) {
        int i=0,j=s.length-1;
        while(i<j){
            char tmp=s[i];
            s[i]=s[j];
            s[j]=tmp;
            i++;
            j--;
        }

    }
}
