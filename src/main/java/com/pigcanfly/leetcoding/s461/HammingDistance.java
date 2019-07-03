package com.pigcanfly.leetcoding.s461;

/**
 * 汉明距离：两个等长字符串之间的汉明距离是两个字符串对应位置的不同
 * 字符的个数。换句话说：它是将一个字符串变成另一个字符串所需要替换的的字符
 * 个数
 * Eg:1011101 与 1001001之间的汉明距离是2
 * 2143896 与 2233796 之间的汉明距离是 3。
 * "toned" 与 "roses" 之间的汉明距离是 3。
 * 计算方式：两个字符串或数字进行异或运算，统计1的数量
 * @author Tobby Quinn
 * @date 2019/07/03
 */
public class HammingDistance {
    public static  int hammingDistance(int x, int y) {
        int res= x^y;
        int size=0;
        while(res !=0){
            int mod=res%2;
            res= res/2;

            if(mod==1){
                size++;
            }

        }
        return size;
    }

    public static void main(String[] args) {
        hammingDistance(93,73);
    }
}
