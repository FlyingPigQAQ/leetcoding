package com.pigcanfly.leetcoding.s762;

/**
 * @author tobbyquinn
 * @date 2019/09/09
 */
public class PrimeNumberofSetBitsinBinaryRepresentation {
    public static int countPrimeSetBits1(int L, int R) {
        int[] prime = new int[20];
        prime[2]=1;
        prime[3]=1;
        prime[5]=1;
        prime[7]=1;
        prime[11]=1;
        prime[13]=1;
        prime[17]=1;
        prime[19]=1;
        int total=0;
        for (int i = L; i <= R; i++) {
            int counts=0,temp=i,index=1;
            while(index<31){
                if((temp&1)==1){
                    counts++;
                }
                index++;
                temp>>=1;
            }
            total+=prime[counts]==1?1:0;
        }
        return total;
    }
    //改造
    public static int countPrimeSetBits(int L, int R) {
        int[] prime = new int[]{0,0,1,1,0,1,0,1,0,0,0,1,0,1,0,0,0,1,0,1};
        int total=0;
        for (int i = L; i <= R; i++) {
            int counts=0,temp=i;
            while(temp>0){
                if((temp&1)==1){
                    counts++;
                }
                temp>>=1;
            }
            total+=prime[counts]==1?1:0;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(2,20));
        System.out.println(Math.pow(10,6 ));
        System.out.println(-1>>>1);
        System.out.println(countPrimeSetBits(10,1000000));
    }
}
