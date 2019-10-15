package com.pigcanfly.leetcoding.s260;



/**
 * TODO：优秀：整体思想，分割两个出现一次的数字，再使用xor得出结果
 * @author tobbyquinn
 * @date 2019/10/11
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for (int num : nums) {
            xor^=num;
        }
        //last set 1
        //正数的补码与负数的补码做与运算
        // 5 & -1  110 & 010
        int separator=xor&-xor;
        int[] res = new int[2];
        for (int num : nums) {
            if((separator&num)==0){
                res[0]^=num;
            }else{
                res[1]^=num;
            }
        }
        return res;
    }
}
