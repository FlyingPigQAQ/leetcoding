package com.pigcanfly.leetcoding.s997;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * TODO: 思考时间很长
 * @author tobbyquinn
 * @date 2019/10/22
 */
public class FindtheTownJudge {
    public int findJudge1(int N, int[][] trust) {
        if(trust.length==0){
            if(N==1){
                return 1;
            }else {
                return -1;
            }
        }
        HashMap<Integer, Integer> dict = new HashMap<>();
        HashMap<Integer, Integer> filter = new HashMap<>();
        for (int[] ts : trust) {
            dict.put(ts[1],dict.getOrDefault(ts[1],0)+1);
            filter.put(ts[0],1);
        }
        List<Map.Entry<Integer, Integer>> res = dict.entrySet().stream().filter(x -> x.getValue() == N - 1)
                .collect(Collectors.toList());
        return res.size()==1?(filter.containsKey(res.get(0).getKey())?-1:res.get(0).getKey()):-1;
    }
    public int findJudge(int N, int[][] trust) {
        if(trust.length == 0) return N == 1 ? 1 : -1;
        int[] trustCount = new int[N+1];
        for(int[] t : trust){
            trustCount[t[1]]++;
            trustCount[t[0]]--;
        }
        for(int i = 1; i < trustCount.length;i++){
            if(trustCount[i] == N-1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] ins ={{1,2}};
        new FindtheTownJudge().findJudge(2,ins);
    }
}
