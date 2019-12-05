package com.pigcanfly.leetcoding.s788;

/**
 * TODO ： DP  LogN
 * @author tobbyquinn
 * @date 2019/10/18
 */
public class RotatedDigits {
    public int rotatedDigits(int N) {
        int res = 0;
        for (int i = 0; i <= N; i++) {
            boolean allIsRotate = true;
            boolean isValid = true;
            int num = i;
            while (num != 0) {
                int single = num % 10;
                if (single == 3 || single == 4 || single == 7) {
                    isValid = false;
                    break;
                }
                if (single == 2 ||single == 5 || single == 6 || single == 9) {
                    allIsRotate = false;
                }
                num /= 10;
            }
            if (isValid && !allIsRotate) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new RotatedDigits().rotatedDigits(10);
    }
}
