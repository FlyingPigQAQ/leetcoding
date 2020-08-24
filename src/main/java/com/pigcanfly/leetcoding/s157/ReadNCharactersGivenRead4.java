package com.pigcanfly.leetcoding.s157;

/**
 * @author tobbyquinn
 * @date 2020/05/18
 */
public class ReadNCharactersGivenRead4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        char[] buf4 = new char[4];
        int readSize=0,total=0;
        while(total<n && (readSize=read4(buf4))>0){
            for(int i=0;i<readSize;i++){
                buf[total++]=buf4[i];
            }
        }
        return Math.min(total,n);
    }
    int read4(char[] buf){
        return 0;
    };
}
