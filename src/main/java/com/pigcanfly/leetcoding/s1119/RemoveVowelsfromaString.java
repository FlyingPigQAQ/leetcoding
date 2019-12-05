package com.pigcanfly.leetcoding.s1119;

/**
 * @author tobbyquinn
 * @date 2019/11/27
 */
public class RemoveVowelsfromaString {
    public String removeVowels(String S) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if(c=='a' || c=='e' ||c=='i'||c=='o'||c=='u'){
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
