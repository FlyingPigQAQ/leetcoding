package com.pigcanfly.leetcoding.s989;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author tobbyquinn
 * @date 2019/11/23
 */
public class AddtoArrayFormofInteger {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int carry=0;
        String k=K + "";
        int[] longest=k.length()>A.length?new int[k.length()]:A;
        for (int i = longest.length-1,j=A.length-1; i >=0 ; i--,j--) {
            int ks=0;
            if(K!=0){
                ks=K%10;
                K/=10;
            }
            int total=ks+carry;
            if(j>=0){
                total+=A[j];
            }
            carry=total/10;
            longest[i]=total%10;
        }
        ArrayList<Integer> res = new ArrayList<>();
        if(carry!=0){
           res.add(carry);
        }
        for (int i : longest) {
            res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new AddtoArrayFormofInteger().addToArrayForm(new int[0], 23));
    }
}
