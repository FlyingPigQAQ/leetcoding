package com.pigcanfly.leetcoding.s1128;

import java.util.HashMap;

/**
 * @author tobbyquinn
 * @date 2019/10/24
 */
public class NumberofEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<String, Integer> cache = new HashMap<>();
        int res=0;
        for (int[] dominoe : dominoes) {
            String dominoeStr=""+dominoe[0]+""+dominoe[1];
            String reverseDominoeStr=""+dominoe[1]+""+dominoe[0];
            if(cache.containsKey(dominoeStr)){
                Integer tmp = cache.get(dominoeStr);
                res+= tmp;
                cache.put(dominoeStr,tmp+1);
            }else if(cache.containsKey(reverseDominoeStr)){
                Integer tmp = cache.get(reverseDominoeStr);
                res+= tmp;
                cache.put(reverseDominoeStr,tmp+1);
            }else {
                cache.put(dominoeStr,1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] ints = {{1,2},{2,1},{3,4},{5,6}};
        int i = new NumberofEquivalentDominoPairs().numEquivDominoPairs(ints);
        System.out.println(i);
    }
}
