package com.pigcanfly.leetcoding.s917;

/**
 * @author tobbyquinn
 * @date 2019/09/25
 */
public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String S) {
        int start=0,end=S.length()-1;
        char[] chars = S.toCharArray();
        while(start<end){
            if(!Character.isLetter(chars[start])){
                start++;
                continue;
            }
            if(!Character.isLetter(chars[end])){
                end--;
                continue;
            }
            char tmp=chars[start];
            chars[start]=chars[end];
            chars[end]=tmp;
            start++;
            end--;
        }
        return String.valueOf(chars);
    }
}
