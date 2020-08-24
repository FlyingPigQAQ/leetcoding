package com.pigcanfly.leetcoding.s582;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Case
 * 1. 杀掉进程0
 * 2. 杀掉进程并无子进程
 * 3. 杀掉的进程包含多个子进程
 * @author tobbyquinn
 * @date 2019/12/27
 */
public class KillProcess {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        if(kill==0){
            return pid;
        }
        HashMap<Integer, ArrayList<Integer>> dict = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            Integer num = ppid.get(i);
            ArrayList<Integer> orDefault = dict.getOrDefault(num, new ArrayList<Integer>());
            orDefault.add(pid.get(i));
            dict.put(num,orDefault);
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(kill);
        searchAll(dict,dict.get(kill), res);
        return res;
    }
    void searchAll(HashMap<Integer, ArrayList<Integer>> dict, ArrayList<Integer> ls, ArrayList<Integer> res){
        if(ls==null){
            return;
        }
        for (Integer num : ls) {
            res.add(num);
            searchAll(dict,dict.get(num),res);
        }
    }
}
