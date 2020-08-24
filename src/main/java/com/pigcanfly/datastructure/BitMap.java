package com.pigcanfly.datastructure;

import scala.Int;

import java.util.Date;

/**
 * @author tobbyquinn
 * @date 2020/07/03
 */
public class BitMap {
    private long[] words ;
    private int size ;
    public BitMap(int bitSize){
        this.size=bitSize;

        //long类型占用64位
        this.words=new long[getWordIndex(bitSize-1)+1];
    }

    public boolean getBit(int bitIndex){
        if(bitIndex<0 || bitIndex>size-1){
            throw new IllegalArgumentException("BitIndex out of bounds");
        }
        int wordIndex = getWordIndex(bitIndex);
        return (words[wordIndex]&1L<<bitIndex)!=0;
    }

    public void setBit(int bitIndex){
        if(bitIndex<0 || bitIndex>size-1){
            throw new IllegalArgumentException("BitIndex out of bounds");
        }
        int wordIndex = getWordIndex(bitIndex);
        words[wordIndex]|=1L<<bitIndex;
    }
    private int getWordIndex(int bitIndex){
        return bitIndex>>6;
    }

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date==null);
        System.out.println(1L << 63);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(1L<< 126);
        System.out.println(1L<< 63);
        long test = 1L<<126;
        long test1 = 1L<<63;
        long test2 = 1L<<64;
        BitMap bitMap = new BitMap(128);
        bitMap.setBit(126);
        bitMap.setBit(123);
        System.out.println(bitMap.getBit(123));
        System.out.println(bitMap.getBit(126));
        System.out.println(bitMap.getBit(1));
    }
}
