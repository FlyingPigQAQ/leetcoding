package com.pigcanfly.leetcoding.s1399;

import java.util.*;

/**
 * @author tobbyquinn
 * @date 2020/05/08
 */
public class CountLargestGroup {
    public int countLargestGroup(int n) {
        Map<Integer,Integer> map =  new HashMap();
        for(int i=1;i<=n;i++){
            int key=sumDigits(i);
            map.put(key,map.getOrDefault(key,0)+1);
        }
        Integer[] cache = new Integer[map.values().size()];
        map.values().toArray(cache);
        Arrays.sort(cache);
        int res=0;
        int max=cache[cache.length-1];
        for(int i=cache.length-1;i>=0;i--){
            if(cache[i]==max){
                res++;
            }else{
                break;
            }
        }
        return res;
    }
    private int sumDigits(int n){
        if(n<10){
            return n;
        }
        int sum=0;
        while(n!=0){
            sum+= n%10;
            n/=10;
        }
        return sum;
    }
}
