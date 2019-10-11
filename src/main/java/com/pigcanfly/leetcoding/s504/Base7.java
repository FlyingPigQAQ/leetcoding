package com.pigcanfly.leetcoding.s504;

/**
 * @author tobbyquinn
 * @date 2019/10/09
 */
public class Base7 {
    public static String convertToBase7(int num) {
        if (num == 0 || num == -0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        boolean negative = false;
        if (num < 0) {
            negative = true;
            num=-num;
        }
        while (num != 0) {
            res.insert(0, num % 7);
            num /= 7;
        }
        if (negative) {
            res.insert(0, "-");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(-7 % 7);
        System.out.println(convertToBase7(-8));
    }
}
