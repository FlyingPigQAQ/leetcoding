package com.pigcanfly.leetcoding.s1018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tobbyquinn
 * @date 2019/10/23
 */
public class BinaryPrefixDivisibleBy5 {
    /**
     * TODO:
     * 31位有效
     * @param A
     * @return
     */
    public List<Boolean> prefixesDivBy5(int[] A) {
        ArrayList<Boolean> rs = new ArrayList<>(A.length);
        for (int i = 0,res=0; i < A.length; i++) {
            res=(res*2+A[i])%5;
            rs.add(res%5==0);
        }
        return rs;
    }


    public static void main(String[] args) {
        new BinaryPrefixDivisibleBy5().prefixesDivBy5(new int[]{1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,
                0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1});
    }

}
