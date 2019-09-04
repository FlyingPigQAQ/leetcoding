package com.pigcanfly.leetcoding.s739;

import java.util.Stack;

/**
 * @author tobbyquinn
 * @date 2019/09/03
 */
public class DailyTemperatures {
    public static int[] dailyTemperatures1(int[] T) {
        int[] res = new int[T.length];
        res[T.length-1]=0;
        for (int i = T.length - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < T.length) {
                if (T[j] > T[i]) {
                    res[i]=j-i;
                    break;
                }
                j++;
            }
            res[i]=j-i;
        }
        return res;
    }
    public static int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack();
        for (int i = T.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }
}
