package com.pigcanfly.leetcoding.s937;

import java.util.Arrays;

/**
 *
 * TODO 复习Java Comparator接口
 * 0 48 9 57
 * a 97 z 122
 *
 * @author Tobby Quinn
 * @date 2019/07/05
 */
public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] s1 = log1.split(" ", 2);
            String[] s2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(s1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(s1[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = s1[1].compareTo(s2[1]);
                if (cmp != 0) {
                    return cmp;
                }
                return s1[0].compareTo(s2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }

    public static void main(String[] args) {
        String s = "a1 9 2 3 1";
        String s1 = s.substring(s.indexOf(" ") + 1);
        String substring = s.substring(0, s.indexOf(" "));
        System.out.println(substring);
        String[] strings = new String[3];
        System.out.println(strings[0]);
        String[] s2 = s.split(" ", 2);
        System.out.println(s2[0]);
        System.out.println(s2[1]);
    }
}
