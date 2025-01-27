package com.pigcanfly.leetcoding.s412;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tobbyquinn
 * @date 2019/10/21
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 1; i <=n; i++) {
            if(i%3==0 && i%5==0){
                res.add("FizzBuzz");

            }else if(i%3==0){
                res.add("Fizz");

            }else if(i%5==0){
                res.add("Buzz");
            }else{
                res.add(""+i);
            }
        }
        return res;
    }

}
