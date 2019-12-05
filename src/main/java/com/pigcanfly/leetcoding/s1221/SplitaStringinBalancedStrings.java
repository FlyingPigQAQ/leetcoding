package com.pigcanfly.leetcoding.s1221;

/**
 * @author tobbyquinn
 * @date 2019/10/17
 */
public class SplitaStringinBalancedStrings {
    public int balancedStringSplit(String s) {
        int r = 0, l = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'R') {
                r++;
            } else {
                l++;
            }
            if (r == l) {
                res++;
                r = 0;
                l = 0;
            }
        }
        return res;
    }
}
