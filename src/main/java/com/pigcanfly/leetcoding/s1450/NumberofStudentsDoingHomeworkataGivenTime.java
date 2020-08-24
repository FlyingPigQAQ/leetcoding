package com.pigcanfly.leetcoding.s1450;

/**
 * @author tobbyquinn
 * @date 2020/05/20
 */
public class NumberofStudentsDoingHomeworkataGivenTime {
    // public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
    //     int[] studentsOfTime = new int[1001];
    //     for(int i=0;i<startTime.length;i++){
    //         for(int j=startTime[i];j<=endTime[i];j++){
    //             studentsOfTime[j]++;
    //         }
    //     }
    //     return studentsOfTime[queryTime];
    // }
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res=0;
        for(int i=0;i<startTime.length;i++){
            if(startTime[i]<=queryTime && queryTime<=endTime[i]){
                res++;
            }
        }
        return res;
    }
}
