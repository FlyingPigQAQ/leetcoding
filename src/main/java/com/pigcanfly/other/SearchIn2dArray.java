package com.pigcanfly.other;

/**
 * TODO:还得多练！！！！，小辣鸡！！
 * @author tobbyquinn
 * @date 2019/09/06
 */
public class SearchIn2dArray {
    public static boolean Find1(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            int left = 0, right = array[0].length - 1;
            while (left <= right) {
                int sMid = left + (right - left) / 2;
                if (array[i][sMid] == target) {
                    return true;
                }
                if (array[i][sMid] < target) {
                    left = sMid + 1;
                    continue;
                }
                if (array[i][sMid] > target) {
                    right = sMid - 1;
                    continue;
                }
            }
        }
        return false;
    }
    public static boolean Find(int target, int[][] array) {
       int row=0,col=array[0].length-1;
       while(row<array.length && col>=0){
           if(array[row][col]==target){
               return true;
           }
           if(array[row][col]<target){
               row++;
               continue;
           }
           if(array[row][col]>target){
               col--;
               continue;
           }
       }
        return false;
    }

    public static void main(String[] args) {
        int arg[][] = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(Find(16, arg));
    }
}
