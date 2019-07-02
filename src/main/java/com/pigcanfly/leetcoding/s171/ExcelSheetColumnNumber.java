package com.pigcanfly.leetcoding.s171;

/**
 * @author Tobby Quinn
 * @date 2019/06/29
 */
public class ExcelSheetColumnNumber {
    public static int titleToNumber(String s) {

        int sum=0,n=s.length();
        for (int i = 0; i < n; i++) {
            double pow = Math.pow(26, n - 1 - i);
            sum+=(s.charAt(i)-'A'+1)*pow;
        }
        return sum;

    }

    public static void main(String[] args) {
        int a = titleToNumber("ZY");
        System.out.println(a);
    }
}
