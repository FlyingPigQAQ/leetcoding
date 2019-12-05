package com.pigcanfly.leetcoding.s1237;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tobbyquinn
 * @date 2019/10/27
 */
public class FindPositiveIntegerSolutionforaGivenEquation {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        outer:for (int i = 1; i <=1000; i++) {
            for (int j = 1; j <=1000; j++) {
                int f = customfunction.f(i, j);
                if(f==z){
                    res.add(Arrays.asList(i, j));
                    continue outer;
                }else if(f>z){
                    continue outer;
                }
            }
        }
        return res;
    }
}

class CustomFunction {
    // Returns f(x, y) for any given positive integers x and y.
    // Note that f(x, y) is increasing with respect to both x and y.
    // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
    public int f(int x, int y) {
        return 0;
    }

    ;
}
