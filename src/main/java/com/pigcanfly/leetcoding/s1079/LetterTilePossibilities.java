package com.pigcanfly.leetcoding.s1079;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author tobbyquinn
 * @date 2019/10/30
 */
public class LetterTilePossibilities {
    public int numTilePossibilities(String tiles) {
        ArrayList<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        return set.size();
    }






    public static void main(String[] args) {
//        int aab = new LetterTilePossibilities().numTilePossibilities("AAABBC");
//        System.out.println(aab);
        int arg=6;
        int res=0;
        for (int i = arg,j=1,temp=1; i >=j ; i--) {
            temp*=i;
            if(i==j){
                i=arg+1;
                res+=temp;
                temp=1;
                j++;
            }
        }

        System.out.println(res);

    }

}
