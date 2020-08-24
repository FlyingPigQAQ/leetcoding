package com.pigcanfly.leetcoding.s1446;

/**
 * @author tobbyquinn
 * @date 2020/05/20
 */
public class ConsecutiveCharacters {
    public int maxPower(String s) {
        int res=1,tmp=1;
        char lastChar=s.charAt(0);
        for(int i=1;i<s.length();i++){
            char c = s.charAt(i);
            if(c!=lastChar){
                res=Math.max(res,tmp);
                tmp=0;
                lastChar=c;
            }
            tmp++;
        }
        return Math.max(res,tmp);
    }
}
