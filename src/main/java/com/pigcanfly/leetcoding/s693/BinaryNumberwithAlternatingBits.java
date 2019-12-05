package com.pigcanfly.leetcoding.s693;

/**
 * @author tobbyquinn
 * @date 2019/10/30
 */
public class BinaryNumberwithAlternatingBits {
    public static  boolean hasAlternatingBits(int n) {
        int index=0;
        int x= (int) Math.pow(2,30);
        for (; index <31 ; index++) {
            if(((n<<index)&x)==x){
                break;
            }
        }
        int iter=31-index;
        int lastBit=n&1;
        for (int i = 1; i <=iter; i++) {
            int currLastBit=(n>>i)&1;
            if(currLastBit==lastBit){
                return false;
            }
            lastBit=currLastBit;
        }
        return true;
    }
    public static void main(String[] args) {
        hasAlternatingBits(14);
    }
}
