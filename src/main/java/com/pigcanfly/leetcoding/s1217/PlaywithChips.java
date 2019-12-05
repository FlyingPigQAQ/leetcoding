package com.pigcanfly.leetcoding.s1217;

import javax.swing.plaf.IconUIResource;
import java.util.Arrays;

/**
 * 奇数到奇数cost 0 偶数到偶数cost 0,最终是将奇数或偶数中最小数一方移动到最大数一方
 * @author tobbyquinn
 * @date 2019/11/09
 */
public class PlaywithChips {
    public int minCostToMoveChips(int[] chips) {
        int odd=0,even=0;
        for (int chip : chips) {
            if(chip%2==0){
                even++;
            }else {
                odd++;
            }
        }
        return Math.min(odd,even);
    }

}
