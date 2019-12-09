package com.pigcanfly.leetcoding.s1271;

import java.util.HashMap;

/**
 * @author tobbyquinn
 * @date 2019/12/05
 */
public class Hexspeak {
    public String toHexspeak(String num) {
        HashMap<Long, String> cache = new HashMap<>();
        cache.put(0L,"O");
        cache.put(1L,"I");
        cache.put(10L,"A");
        cache.put(11L,"B");
        cache.put(12L,"C");
        cache.put(13L,"D");
        cache.put(14L,"E");
        cache.put(15L,"F");
        StringBuilder sb = new StringBuilder();
        long n = Long.parseLong(num);
        do {
            long l = n & 0xf;
            if (cache.containsKey(l)) {
                sb.append(cache.get(l));
            }else {
                return "ERROR";
            }
            n>>=4;
        }while (n!=0);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(1000000000000L);
    }
}
