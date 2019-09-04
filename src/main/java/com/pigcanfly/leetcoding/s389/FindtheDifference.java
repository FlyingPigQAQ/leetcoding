package com.pigcanfly.leetcoding.s389;

/**TODO：异或操作符
 * TODO：sum(a)-sum(b)
 * @author tobbyquinn
 * @date 2019/09/03
 */
public class FindtheDifference {
    public char findTheDifference(String s, String t) {
        int[] sa = new int[26];
        int[] ta = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sa[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            ta[t.charAt(i)-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if(ta[i]!=sa[i]){
                return(char) ('a'+i);
            }
        }
        return '0';

    }
}
