package com.pigcanfly.leetcoding.s62;

import java.util.HashMap;

/**
 * TODO:更好的方式DP
 * @author tobbyquinn
 * @date 2019/10/31
 */
public class UniquePaths {
    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    public int uniquePaths(int m, int n) {
        if(m<1 || n<1){
            return 0;
        }
        if(m==1 &&n==1){
            return 1;
        }
        if(map.containsKey(m*1000+n)){
            return map.get(m*1000+n);
        }
        map.put(m*1000+n,uniquePaths(m - 1, n)+uniquePaths(m, n - 1));
        return map.get(m*1000+n);
    }

    public static void main(String[] args) {
        int i = new UniquePaths().uniquePaths(7, 3);
        System.out.println(i);
    }
}
