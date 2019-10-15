package com.pigcanfly.leetcoding.s763;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author tobbyquinn
 * @date 2019/10/14
 */
public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        //int[] start end distance
        HashMap<Character, int[]> dict = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if(dict.containsKey(c)){
                int[] tmp = dict.get(c);
                tmp[1]=i;
                tmp[2]=tmp[1]-tmp[0]+1;
                dict.put(c,tmp);
            }else{
                dict.put(c,new int[]{i,i,1});
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int[] tmp = dict.get(c);
            int maxRemoteIndex=i+tmp[2]-1;
            int end=tmp[1];
            for (int j = i; j <=end; j++) {
                char tmpC = S.charAt(j);
                int[] tmp1 = dict.get(tmpC);
                maxRemoteIndex=Math.max(maxRemoteIndex,tmp1[1]);
                end=maxRemoteIndex;
            }
            res.add(maxRemoteIndex-i+1);
            i=maxRemoteIndex;
        }
        return res;
    }

    public static void main(String[] args) {
        new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij");
    }
}
