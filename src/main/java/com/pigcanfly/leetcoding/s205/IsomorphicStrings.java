package com.pigcanfly.leetcoding.s205;

import java.util.HashMap;

/**
 * TODO： 重要！,这么简单都做错。。
 *
 *
 * @author tobbyquinn
 * @date 2019/10/24
 */
public class IsomorphicStrings {
    public boolean isIsomorphic1(String s, String t) {
        int[] ss = new int[128];
        int[] tt = new int[128];
        for (int i = 0; i < ss.length; i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            if(ss[sc]!=tt[tc]){
                return false;
            }
            //加一避免0的情况出现(与初始化数值重复)
            ss[sc]=i+1;
            tt[tc]=i+1;
        }
        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> ss = new HashMap<>();
        HashMap<Character, Character> tt = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            if(ss.containsKey(sc) && ss.get(sc)!=tc){
                return false;
            }
            if(tt.containsKey(tc) && tt.get(tc)!=sc){
                return false;
            }
            ss.put(sc, tc);
            tt.put(tc, sc);
            if (ss.get(sc) != null && tt.get(tc) != null && tt.get(ss.get(sc))!=sc) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new IsomorphicStrings().isIsomorphic("ab", "ca"));
    }
}
