package com.pigcanfly.leetcoding.s758;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author tobbyquinn
 * @date 2019/12/11
 */
public class BoldWordsinString {
    public String boldWords(String[] words, String S) {
        HashSet<String> set = new HashSet<>(Arrays.asList(words));
        StringBuilder sb = new StringBuilder();
        int[] cache = new int[S.length()];
        int currentStart=-1,currentEnd=-1;
        for (int i = 0; i < S.length(); i++) {
            for (int j = i+1; j <= S.length(); j++) {
                if(set.contains(S.substring(i,j))){
                    currentStart=i;
                    currentEnd=Math.max(j-1,currentEnd);
                }
            }
            if(currentStart!=-1){
                for (int j = currentStart; j <=currentEnd; j++) {
                    cache[j]=1;
                }
            }
            currentStart=-1;
            currentEnd=-1;
        }
        int index=0;
        boolean conti=false;
        while(index<cache.length){
            if(cache[index]==0){
                if(conti){
                    sb.append("</b>");
                    conti=false;
                }
            }else {
                if(!conti){
                    sb.append("<b>");
                    conti=true;
                }
            }
            sb.append(S.charAt(index));
            index++;
        }
        if(conti){
            sb.append("</b>");
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        new BoldWordsinString().boldWords(new String[]{"e","cab","de","cc","db"},"cbccceeead");
    }
}
