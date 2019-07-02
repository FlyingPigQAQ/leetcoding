package com.pigcanfly.leetcoding.s933;

import java.util.ArrayDeque;

/**
 * @author Tobby Quinn
 * @date 2019/06/28
 */
public class NumberOfRecentCalls {

    //TODO:return 队列中size即可
    private static class RecentCounter {

        private ArrayDeque<Integer> q1;
        private ArrayDeque<Integer> q2;

        public RecentCounter() {
            q1=new ArrayDeque<>();
            q2=new ArrayDeque<>();


        }

        public int ping(int t) {
            int times=1;

           while (!q1.isEmpty()){
               Integer head = q1.pop();
               if(head>=t-3000){
                   q2.addLast(head);
                   times++;
               }
           }
           q2.addLast(t);
           //交换
           ArrayDeque<Integer> tmp;
           tmp=q1;
           q1=q2;
           q2=tmp;
            return times;
        }
    }

    public static void main(String[] args) {
        RecentCounter obj = new RecentCounter();
        System.out.println(obj.ping(1));
        System.out.println(obj.ping(100));
        System.out.println(obj.ping(3001));
        System.out.println(obj.ping(3002));
    }

}
