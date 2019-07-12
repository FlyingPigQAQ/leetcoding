package com.pigcanfly.leetcoding.s476;

/** TODO： ~num & ((Integer.highestOneBit(num) << 1) - 1);
 * @author Tobby Quinn
 * @date 2019/07/11
 */
public class NumberComplement {
    public static int findComplement(int num) {
        int[] t = new int[31];
        int maxIndex=0,res=0;
        for (int i = 0; i < 31; i++) {
            int tmp = num&1;
            if(tmp!=0){
                t[i]=1;
                maxIndex=i;
            }
            num = num >> 1;
        }
        for (int i = 0; i <=maxIndex; i++) {
            if(t[i]==0){
                res+=Math.pow(2,i);
            }
        }
        return res;
    }
    public static int findComplement1(int num) {
        return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }

    public static void main(String[] args) {
        int complement = findComplement(5);
        System.out.println(complement);
        System.out.println();
        System.out.println(Integer.highestOneBit(4));

        System.out.println(~5);
    }
}
