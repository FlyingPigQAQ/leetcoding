package com.pigcanfly.leetcoding.s202;

import java.util.HashMap;

/**
 * @author Tobby Quinn
 * @date 2019/08/24
 */
public class HappyNumber {
   HashMap<Integer,Integer> cache =  new HashMap();
    public  boolean isHappy(int n) {

        if (n == 1 ) {
            return true;
        }


        int sum = 0;
        while (n / 10 != 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        sum += Math.pow(n  , 2);
        if(cache.containsKey(sum)){
            return false;
        }else{
            cache.put(sum,1);
        }
        return isHappy(sum);
    }

    //方法改在
    public  boolean isHappy1(int n) {

        if (n == 1 ) {
            return true;
        }
        int sum = 0;
        while (n !=0 ) {
            int tmp = n % 10;
            sum += tmp*tmp;
            n /= 10;
        }
        if(cache.containsKey(sum)){
            return false;
        }else{
            cache.put(sum,1);
        }
        return isHappy(sum);
    }

    /**
     * 追及问题解决
     * @param n
     * @return
     */
    int digitSquareSum(int n) {
        int sum = 0, tmp;
        while (n!=0) {
            tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }
    boolean isHappy2(int n) {
        int slow, fast;
        slow = fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
        } while(slow != fast);
        if (slow == 1) {
            return true;
        } else {
            return false;
        }
    }



    public static void main(String[] args) {
        boolean happy = new HappyNumber().isHappy(19);
        System.out.println(happy);

        boolean happy1 = new HappyNumber().isHappy(2);
        System.out.println(happy1);

        boolean happy2 = new HappyNumber().isHappy(1111111);
        System.out.println(happy2);
    }
}
