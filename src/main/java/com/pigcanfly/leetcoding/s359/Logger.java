package com.pigcanfly.leetcoding.s359;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author tobbyquinn
 * @date 2020/04/28
 */
public class Logger {
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

    /**
     * Initialize your data structure here.
     */
    public Logger() {
        q = new LinkedList<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        int len = q.size();
        boolean shouldPrint = true;
        for (int i = 0; i < len; i++) {
            Pair pair = q.poll();
            //数据有效
            if (timestamp - pair.getTimestamp() < 10) {
                if (pair.getMessage().equals(message)) {
                    shouldPrint = false;
                }
                q.add(pair);
            }
        }
        if(shouldPrint){
            q.add(new Pair(timestamp, message));
        }
        System.out.println(shouldPrint);
        return shouldPrint;
    }


    public static void main(String[] args) {
        Logger logger = new Logger();

// logging string "foo" at timestamp 1
        logger.shouldPrintMessage(1, "foo");// return true;

// logging string "bar" at timestamp 2
        logger.shouldPrintMessage(2, "bar"); // returns true;

// logging string "foo" at timestamp 3
        logger.shouldPrintMessage(3, "foo"); // returns false;

// logging string "bar" at timestamp 8
        logger.shouldPrintMessage(8, "bar"); // returns false;

// logging string "foo" at timestamp 10
        logger.shouldPrintMessage(10, "foo"); // returns false;

// logging string "foo" at timestamp 11
        logger.shouldPrintMessage(11, "foo"); // returns true;
    }
}
