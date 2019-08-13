package com.pigcanfly.leetcoding.s717;

/**
 * @author Tobby Quinn
 * @date 2019/07/16
 */
public class bit1and2bitCharacters {
    public static boolean isOneBitCharacter(int[] bits) {
        int len=bits.length,last=0;
        if(bits[len-1]==1){
            return false;
        }

        for (int i = 0; i < len;) {

            if(bits[i]==0){
                last=0;
                i++;
                continue;
            }
            if(bits[i]==1){
                last=1;
                i+=2;
            }
        }

        return last==0;
    }

    public static void main(String[] args) {
        isOneBitCharacter(new int[]{1,0,0});
    }
}
