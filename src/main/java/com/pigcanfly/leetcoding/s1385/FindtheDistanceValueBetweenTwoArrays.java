package com.pigcanfly.leetcoding.s1385;

/**
 * @author tobbyquinn
 * @date 2020/04/30
 */
public class FindtheDistanceValueBetweenTwoArrays {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int res = 0;
        for (int a1 : arr1) {
            boolean isExists = true;
            for (int a2 : arr2) {
                if (Math.abs(a1 - a2) <= d) {
                    isExists = false;
                }
            }
            if (isExists) {
                res++;
            }
        }
        return res;
//         int res = 0;
//         TreeSet<Integer> ts = new TreeSet<>();
//         for(int n : arr2)
//             ts.add(n);

//         for(int n : arr1){
//             Integer higher = ts.ceiling(n);
//             Integer lower = ts.floor(n);
//             int diff = 0;
//             if(higher == null){
//                 diff = Math.abs(lower - n);
//             }else if(lower == null){
//                 diff = Math.abs(higher - n);
//             }else{
//                 diff = Math.min(higher - n, n - lower);
//             }
//             if(diff > d)
//                 res++;
//         }
//         return res;
    }
}
