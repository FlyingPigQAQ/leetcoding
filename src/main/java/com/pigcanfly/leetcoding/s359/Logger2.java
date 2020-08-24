package com.pigcanfly.leetcoding.s359;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author tobbyquinn
 * @date 2020/04/28
 */
public class Logger2 {
    class Pair {
        private int timestamp;
        private String message;

        public Pair(int timestamp, String message) {
            this.timestamp = timestamp;
            this.message = message;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public String getMessage() {
            return message;
        }
    }

    Queue<Pair> q = null;
    HashSet<String> set = null;

    /**
     * Initialize your data structure here.
     */
    public Logger2() {

        q = new LinkedList<>();
        set = new HashSet<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        boolean shouldPrint = true;
        //清理过期数据
        while (!q.isEmpty()){
            Pair pair = q.peek();
            if(timestamp-pair.getTimestamp()>=10){
                q.poll();
                set.remove(pair.getMessage());
            }else {
                break;
            }
        }
        if(!set.contains(message)){
            set.add(message);
            q.add(new Pair(timestamp, message));
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Logger2 logger = new Logger2();

// logging string "foo" at timestamp 1
        System.out.println(logger.shouldPrintMessage(1, "foo"));

// logging string "bar" at timestamp 2
        System.out.println(logger.shouldPrintMessage(2, "bar"));

// logging string "foo" at timestamp 3
        System.out.println(logger.shouldPrintMessage(3, "foo"));

// logging string "bar" at timestamp 8
        System.out.println(logger.shouldPrintMessage(8, "bar"));

// logging string "foo" at timestamp 10
        System.out.println(logger.shouldPrintMessage(10, "foo"));

// logging string "foo" at timestamp 11
        System.out.println(logger.shouldPrintMessage(11, "foo"));
    }
}
