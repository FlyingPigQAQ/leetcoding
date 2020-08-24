package com.pigcanfly.leetcoding.s797;


import java.util.ArrayList;
import java.util.List;

/**
 * @author tobbyquinn
 * @date 2020/08/24
 */
public class AllPathsFromSourcetoTarget {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        allPathsSourceTarget(graph, 0, new ArrayList<Integer>());
        return res;
    }

    public void allPathsSourceTarget(int[][] graph, int index, ArrayList<Integer> arr) {

        if (index == graph.length - 1) {
            res.add(arr);
            return;
        }

        for (int i = 0; i < graph[index].length; i++) {
            ArrayList<Integer> tmp = new ArrayList<>(arr);
            if (arr.size() == 0) {
                tmp.add(index);
            }
            int idx = graph[index][i];
            tmp.add(idx);
            allPathsSourceTarget(graph, idx, tmp);
        }
    }


    public static void main(String[] args) {
        int[][] arg = {{1, 2}, {3}, {3}, {}};
        List<List<Integer>> lists = new AllPathsFromSourcetoTarget().allPathsSourceTarget(arg);
        lists.forEach(x -> {
            System.out.println(x);
        });
    }
}
