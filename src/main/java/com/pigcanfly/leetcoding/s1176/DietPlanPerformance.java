package com.pigcanfly.leetcoding.s1176;

/**
 * @author tobbyquinn
 * @date 2019/12/13
 */
public class DietPlanPerformance {
    public int dietPlanPerformance1(int[] calories, int k, int lower, int upper) {
        int sum = 0;
        for (int i = 0; i < (k == 1 ? calories.length : calories.length - k + 1); i++) {
            int tmp = 0;
            for (int j = i; j < i + k; j++) {
                tmp += calories[j];
            }
            if (tmp < lower) {
                sum--;
            } else if (tmp > upper) {
                sum++;
            }
        }
        return sum;
    }

    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int sum = 0,result=0;
        for (int i = 0; i < calories.length; i++) {
            sum+=calories[i];
            if(i>k-1){
                if(sum<lower){
                    result--;
                }else if(sum>upper){
                    result++;
                }
                sum-=calories[i-k];
            }
        }
        return result;
    }
}
