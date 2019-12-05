package com.pigcanfly.leetcoding.s392;

/**
 * @author tobbyquinn
 * @date 2019/11/06
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if("".equals(s)){
            return true;
        }
        for (int i = 0,index=0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(c==s.charAt(index)){
                index++;
            }
            if(index==s.length()){
                return true;
            }
        }
        return false;
    }
}
