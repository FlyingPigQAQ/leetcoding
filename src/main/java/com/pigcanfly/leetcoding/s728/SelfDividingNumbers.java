package com.pigcanfly.leetcoding.s728;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tobby Quinn
 * @date 2019/07/02
 */
public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int tmp = i;
            while(tmp!=0){
                int mod = tmp%10;
                int divid = tmp/10;
                //考虑 700，708 0的不同位置
                if(mod==0 || i%mod!=0){
                    break;
                }
                tmp = divid;
                if(tmp==0){
                    res.add(i);
                }
            }
        }
        return res;

    }
}
