package com.pigcanfly.leetcoding.s1332;

/**
 * @author tobbyquinn
 * @date 2020/02/21
 */
public class RemovePalindromicSubsequences {
    public int removePalindromeSub(String s) {
        if("".equals(s)){
            return 0;
        }
        return new StringBuilder(s).reverse().toString().equals(s)?1:0;
    }
}
