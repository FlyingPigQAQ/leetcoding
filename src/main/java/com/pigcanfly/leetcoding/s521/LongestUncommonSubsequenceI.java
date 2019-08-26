package com.pigcanfly.leetcoding.s521;

/**
 * @author Tobby Quinn
 * @date 2019/08/24
 */
public class LongestUncommonSubsequenceI {
    public int findLUSlength(String a, String b) {
        if(a.equals(b)){
            return -1;
        }
        return Math.max(a.length(),b.length());
    }
}
