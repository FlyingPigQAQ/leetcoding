package com.pigcanfly.leetcoding.s263;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Tobby Quinn
 * @date 2019/08/12
 */
public class UglyNumber {
    public boolean isUgly(int num) {
       if(num<1){
           return false;
       }
       if(1<=num && num<=5){
           return true;
       }
        HashMap<Integer, Integer> dict = new HashMap<>();
        while(true){
            if(num%2==0){
                dict.put(2,1);
                num=num/2;
                continue;
            }else if(num%3==0){
                dict.put(3,1);
                num=num/3;
                continue;
            }else if(num%5==0){
                dict.put(5,1);
                num=num/5;
                continue;
            }else {
                dict.put(num,1);
                break;
            }
        }
        Iterator<Integer> iter = dict.keySet().iterator();
       while (iter.hasNext()){
           Integer next = iter.next();
           if(next!=1 && next!=2 && next!=3 && next!=5){
               return false;
           }
       }
       return true;
    }
    public boolean isUgly1(int num) {
        if(num==1) return true;
        if(num==0) return false;
        while(num%2==0) num=num>>1;
        while(num%3==0) num=num/3;
        while(num%5==0) num=num/5;
        return num==1;
    }
}
