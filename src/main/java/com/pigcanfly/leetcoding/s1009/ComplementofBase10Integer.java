package com.pigcanfly.leetcoding.s1009;

/**
 * @author tobbyquinn
 * @date 2019/09/03
 */
public class ComplementofBase10Integer {
    public static int bitwiseComplement(int N) {
        int bitCounts=1,mov=1;
        while((N>>mov)>0){
            bitCounts=(bitCounts<<1)+1;
            mov++;
        }
        return N^bitCounts;
    }

    public static void main(String[] args) {
        int i = bitwiseComplement(0);
        System.out.println(i);
    }
}
