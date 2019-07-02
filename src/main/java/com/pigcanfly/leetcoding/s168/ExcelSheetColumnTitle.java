package com.pigcanfly.leetcoding.s168;

/**
 * @author Tobby Quinn
 * @date 2019/06/19
 */
public class ExcelSheetColumnTitle {
    StringBuilder sb = new StringBuilder();

    public String convertToTitle1(int n) {
        if (n < 27) {
            return String.valueOf((char) ('A' + n - 1));
        }
        StringBuilder sb = new StringBuilder();
        int consult;
        while (n / 26 != 0) {
            consult = n / 26;
            int mod = n % 26;
            if (mod == 0) {
                consult -= 1;
                sb.insert(0, 'Z');
            } else {
                sb.insert(0, (char) ('A' + mod - 1));
            }

            n = consult;

        }
        if (n != 0) {
            sb.insert(0, (char) ('A' + n - 1));
        }

        return sb.toString();
    }

    public String convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle(--n / 26) + (char) ('A' + (n % 26));
    }


    public static void main(String[] args) {
        ExcelSheetColumnTitle obj = new ExcelSheetColumnTitle();
        String s = obj.convertToTitle(26);
        System.out.println(s);
        int n=3;
        System.out.println(--n*2);
    }
}
