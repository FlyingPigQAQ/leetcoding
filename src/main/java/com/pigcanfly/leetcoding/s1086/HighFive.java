package com.pigcanfly.leetcoding.s1086;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/**
 * @author tobbyquinn
 * @date 2019/11/27
 */
public class HighFive {
    public int[][] highFive(int[][] items) {
        HashMap<Integer, int[]> cache = new HashMap<>();
        for (int[] item : items) {
            int id = item[0],score=item[1];
            if(cache.containsKey(id)){
                int[] arr = cache.get(id);
                if(score>arr[4]){
                    for (int i = 0; i < arr.length; i++) {
                        if(score>arr[i]){
                            int j=i;
                            int next=arr[j];
                            while (j<arr.length-1){
                                int cur=next;
                                next=arr[j+1];
                                arr[j+1]=cur;
                                j++;
                            }
                            arr[i]=score;
                            cache.put(id,arr);
                            break;
                        }
                    }
                }
            }else {
                cache.put(id,new int[]{score,0,0,0,0});
            }
        }
        int[][] res = new int[cache.size()][2];
        Iterator<Map.Entry<Integer, int[]>> iterator = cache.entrySet().iterator();
        int index=0;
        while (iterator.hasNext()){
            Map.Entry<Integer, int[]> entry = iterator.next();
            res[index][0]=entry.getKey();
            res[index][1]=IntStream.of(entry.getValue()).sum()/5;
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arg={{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        new HighFive().highFive(arg);
    }
}
