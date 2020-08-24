package com.pigcanfly.leetcoding.s1323;

/**
 * @author tobbyquinn
 * @date 2020/02/03
 */
public class Maximum69Number {
    public int maximum69Number(int num) {
        return Integer.parseInt(String.valueOf(num).replaceFirst("6", "9"));
    }

    public static void main(String[] args) {
        System.out.println(new Maximum69Number().maximum69Number(9669));
    }
}
