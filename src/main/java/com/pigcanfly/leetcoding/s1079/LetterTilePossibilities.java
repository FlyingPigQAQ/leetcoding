package com.pigcanfly.leetcoding.s1079;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author tobbyquinn
 * @date 2019/10/30
 */
public class LetterTilePossibilities {
    public int numTilePossibilities(String tiles) {
        int res=0;
        for (int i = tiles.length(),j=1,temp=1; i >=j ; i--) {
            temp*=i;
            if(i==j){
                i=tiles.length();
                res+=temp;
                temp=1;
                j++;
            }
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < tiles.length(); i++) {
            set.add(tiles.charAt(i));
        }
        int diff=tiles.length()-set.size();
        if(set.size()==tiles.length()){
            return res;
        }
        int perNum=res/tiles.length();
        return res;



    }

    public int numUniqueCharacterOfTilePossibilities(String tiles){
        int res=0;
        for (int i = tiles.length(),j=1,temp=1; i >=j ; i--) {
            temp*=i;
            if(i==j){
                i=tiles.length();
                res+=temp;
                temp=1;
                j++;
            }
        }
        return res;
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
