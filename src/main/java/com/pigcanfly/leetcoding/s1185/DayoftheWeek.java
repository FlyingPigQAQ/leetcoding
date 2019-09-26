package com.pigcanfly.leetcoding.s1185;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author tobbyquinn
 * @date 2019/09/09
 */
public class DayoftheWeek {
    public static String dayOfTheWeek1(int day, int month, int year) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("EEEE");
        try {
            Date date = dateFormat.parse("" + year + "-" + month + "-" + day);
            String res = dateFormat1.format(date);
            return res;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 蔡勒公式[https://zh.wikipedia.org/wiki/%E8%94%A1%E5%8B%92%E5%85%AC%E5%BC%8F]
     * @param day
     * @param month
     * @param year
     * @return
     */
    public static String dayOfTheWeek(int day, int month, int year) {
        String cal[]={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        if(month<3){
            month+=12;
            year-=1;
        }
        int c=year/100;
        int y=year%100;
        int w = (y+y/4+c/4-2*c+26*(month+1)/10+day-1)%7;
        //负数取余
        w=(w%7+7)%7;
        return cal[w];
    }

    public static void main(String[] args) {
        System.out.println(dayOfTheWeek1(31, 8, 2019));
    }
}
