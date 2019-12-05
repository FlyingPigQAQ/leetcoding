package com.pigcanfly.leetcoding.s1252.s125;

/**
 * @author tobbyquinn
 * @date 2019/11/22
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if("".equals(s)){
            return true;
        }
        s=s.toLowerCase();
        int left=0,right=s.length()-1;
        while (left<right){
            char lc = s.charAt(left);
            if(!Character.isLetter(lc) && !Character.isDigit(lc)){
                left++;
                continue;
            }

            char rc = s.charAt(right);
            if(!Character.isLetter(rc) && !Character.isDigit(rc)){
                right--;
                continue;
            }
            if(rc!=lc){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
