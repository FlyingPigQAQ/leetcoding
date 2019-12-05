package com.pigcanfly.leetcoding.s434;

/**
 * @author tobbyquinn
 * @date 2019/10/24
 */
public class NumberofSegmentsinaString {
    public int countSegments(String s) {
        s=s.trim();
        if("".equals(s)){
            return 0;
        }
        return s.split("\\s+").length;
    }

    public static void main(String[] args) {
        String s= "";
        String[] split = s.split("[,| |;|.|!]+");
        System.out.println(split.length);
    }
}
