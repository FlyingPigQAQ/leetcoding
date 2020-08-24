package com.pigcanfly.leetcoding.s1360;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @author tobbyquinn
 * @date 2020/04/28
 */
public class NumberofDaysBetweenTwoDates {
    public int daysBetweenDates(String date1, String date2) {
        int[] daysForMonthWithoutLeapYear = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] daysForMonthWithLeapYear = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = null, endDate = null;
        try {
            Date p1 = format.parse(date1);
            Date p2 = format.parse(date2);
            int compare = p1.compareTo(p2);
            if (compare == 0) {
                return 0;
            } else if (compare == 1) {
                endDate = p1;
                beginDate = p2;
            } else {
                endDate = p2;
                beginDate = p1;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String[] d1 = format.format(beginDate).split("-");
        String[] d2 = format.format(endDate).split("-");

        int startYear = Integer.parseInt(d1[0]), startMonth = Integer.parseInt(d1[1]), startDay = Integer.parseInt(d1[2]);
        int endYear = Integer.parseInt(d2[0]), endMonth = Integer.parseInt(d2[1]), endDay = Integer.parseInt(d2[2]);

        if (startYear == endYear && startMonth == endMonth) {
            return endDay - startDay;
        }
        int res = 0;
        //不同年
        for (int i = startYear+1; i < endYear; i++) {
            res += isLeapYear(i) ? 366 : 365;
        }
        int[] daysForMonthEndYear = isLeapYear(endYear) ? daysForMonthWithLeapYear : daysForMonthWithoutLeapYear;
        int[] daysForMonthStartYear = isLeapYear(startYear) ? daysForMonthWithLeapYear : daysForMonthWithoutLeapYear;
        if (startYear == endYear) {
            for (int i = startMonth + 1; i < endMonth; i++) {
                res += daysForMonthEndYear[i];
            }
            res += daysForMonthEndYear[startMonth] - startDay;
            res += endDay;
        } else {
            for (int i = startMonth+1; i <= 12; i++) {
                res += daysForMonthStartYear[i];
            }
            res +=daysForMonthStartYear[startMonth]-startDay;
            for (int i = 1; i < endMonth; i++) {
                res += daysForMonthEndYear[i];
            }
            res += endDay;
        }
        return res;
    }

    private boolean isLeapYear(int year) {
        //普通闰年 或 世纪闰年
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void main(String[] args) {
//        System.out.println(new NumberofDaysBetweenTwoDates().daysBetweenDates("2023-01-13"
//                ,"2044-02-11"));

        String str="['title','normal','normal','title','title','normal','normal']";
        Pattern compile = Pattern.compile("(('title',)+.*?)+");
        Matcher matcher = compile.matcher(str);
        System.out.println(matcher.toMatchResult().group(0));
    }
}
