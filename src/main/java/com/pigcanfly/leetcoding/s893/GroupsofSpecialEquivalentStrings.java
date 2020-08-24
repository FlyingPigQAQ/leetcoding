package com.pigcanfly.leetcoding.s893;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 数组放在HashSet中，需要重写equals()等方法
 * 数组可以将其转为字符串，存入set中
 * @author tobbyquinn
 * @date 2020/02/03
 */
public class GroupsofSpecialEquivalentStrings {
    public int numSpecialEquivGroups(String[] A) {
        HashSet<String> sets = new HashSet<>();
        for (String s : A) {
            int[] ca = new int[52];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
//                if (i % 2 == 0) {
//                    ca[c - 'a']++;
//                } else {
//                    ca[c - 'a' + 26]++;
//                }
                ca[c-'a'+26*(i%2)]++;
            }
            sets.add(Arrays.toString(ca));
        }
        return sets.size();
    }

    public static void main(String[] args) {
        String[] strings = {"abcd", "cdab", "cbad", "xyzz", "zzxy", "zzyx"};
        System.out.println(Arrays.toString(strings));
        System.out.println(new GroupsofSpecialEquivalentStrings().numSpecialEquivGroups(strings));
    }
}
