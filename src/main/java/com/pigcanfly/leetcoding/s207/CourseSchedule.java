package com.pigcanfly.leetcoding.s207;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author tobbyquinn
 * @date 2020/01/03
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0){
            return true;
        }
        HashMap<Integer, Integer> pair = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            pair.put(prerequisite[0],prerequisite[1]);
        }
        for (int[] prerequisite : prerequisites) {
            HashSet<Integer> set = new HashSet<>();
            int key=prerequisite[1];
            while(pair.containsKey(key) && !set.contains(key)){
                set.add(key);
                key=pair.get(key);
            }
            if(set.contains(key)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] arg = {{0,2},{1,2},{2,0}};
        new CourseSchedule().canFinish(3,arg);
    }
}
