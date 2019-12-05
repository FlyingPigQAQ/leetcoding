package com.pigcanfly.leetcoding.s1118;

/**
 * @author tobbyquinn
 * @date 2019/11/27
 */
public class NumberofDaysinaMonth {
    public int numberOfDays(int Y, int M) {
        if (M == 2) {
            if (isLeapYear(Y)) {
                return 29;
            } else {
                return 28;
            }
        }
        if (M == 1 || M == 3 || M == 5 || M == 7 || M == 8 || M == 10 || M == 12) {
            return 31;
        } else {
            return 30;
        }
    }

    boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year%400==0;
    }
}
