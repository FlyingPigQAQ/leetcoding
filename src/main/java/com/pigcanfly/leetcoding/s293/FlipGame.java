package com.pigcanfly.leetcoding.s293;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tobbyquinn
 * @date 2019/12/28
 */
public class FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i <= s.length()-2; i++) {
            char c1 = s.charAt(i);
            if(c1=='-'){
                continue;
            }
            char c2 = s.charAt(i+1);
            if(c1==c2 ){
                res.add(s.substring(0,i)+"--"+s.substring(i+2));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("1234".substring(3));
    }
}
