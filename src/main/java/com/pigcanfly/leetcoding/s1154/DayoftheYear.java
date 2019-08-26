package com.pigcanfly.leetcoding.s1154;

/**
 * @author Tobby Quinn
 * @date 2019/08/15
 */
public class DayoftheYear {
    public int dayOfYear(String date) {
        String[] dates = date.split("-");
        int year=Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]);
        int day = Integer.parseInt(dates[2]);
        int dayDiff=0;
        for (int i = 1; i < month; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                dayDiff+=31;
            }else if(i==2) {
                //判断闰年
                if((year%4==0 && year%100!=0) || (year%400==0&& year%3200!=0)){
                    dayDiff+=29;
                }else{
                    dayDiff+=28;
                }
            }else{
                dayDiff+=30;
            }
        }
        return dayDiff+day;
    }
}
