package com.pigcanfly.leetcoding.s633;

/**
 *
 * TODO:费马定理
 * @author tobbyquinn
 * @date 2019/12/06
 */
public class SumofSquareNumbers {
    /**
     * Time Limit Exceeded
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        for (int i = 0; i*i <=c ; i++) {
            for (int j = 0; j*j <= c-i*i; j++) {
                if((j*j+i*i)==c){
                   return true;
                }
            }
        }
        return false;
    }

    /**
     * Time Limit Exceeded
     * @param c
     * @return
     */
    public boolean judgeSquareSum1(int c) {
        for (int i = 0; i*i <=c ; i++) {
            double sqrt = Math.sqrt(c - i * i);
            if(sqrt==(int)sqrt){
                return true;
            }
        }
        return false;
    }
    public boolean judgeSquareSum2(int c) {
        for (long a = 0; a * a <= c; a++) {
            int b =  c - (int)(a * a);
            int i = 1, sum = 0;
            while (sum < b) {
                sum += i;
                i += 2;
            }
            if (sum == b) {
                return true;
            }
        }
        return false;
    }


    public boolean judgeSquareSum3(int c) {
        for ( long i= 0; i*i <=c ; i++) {
            int b=(int)(c-i*i);
            if(binarySearch(0,b,b)){
                return true;
            }
        }

        return false;
    }

    /**
     * TODO：注意点 int 和 int相乘溢出，即使用long接收也不可以，他是将溢出结果赋值给long变量
     * 一定要谨记！
     * @param left
     * @param right
     * @param target
     * @return
     */
    boolean binarySearch(long left,long right,int target){
        while (left<=right){
            long mid=left+((right-left)>>1);
            long res=mid*mid;
            if(res==target){
                return true;
            }else if(res>target){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return false;
    }


    public boolean judgeSquareSum4(int c) {
        for (long a = 0; a * a <= c; a++) {
            int b = c - (int)(a * a);
            if (binary_search(0, b, b))
                return true;
        }
        return false;
    }
    public boolean binary_search(long s, long e, int n) {
        if (s > e)
            return false;
        long mid = s + (e - s) / 2;
        if (mid * mid == n)
            return true;
        if (mid * mid > n)
            return binary_search(s, mid - 1, n);
        return binary_search(mid + 1, e, n);
    }

    public static void main(String[] args) {
        System.out.println(new SumofSquareNumbers().judgeSquareSum3(2147483646));
       // System.out.println(new SumofSquareNumbers().binarySearch(0,998560000,998560000));
       // System.out.println(31600*31600);
    }
}
