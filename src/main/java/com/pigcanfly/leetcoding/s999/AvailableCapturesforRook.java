package com.pigcanfly.leetcoding.s999;

/**
 * TODO 4次循环精简
 * @author tobbyquinn
 * @date 2019/12/05
 */
public class AvailableCapturesforRook {
    public int numRookCaptures(char[][] board) {
        int col=0,row=0;
        //查找R
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]=='R'){
                    row=i;
                    col=j;
                }
            }
        }
        int capture=0;
        //左
        for (int i = col; i >=0 ; i--) {
            if(board[row][i]=='B'){
                break;
            }
            if(board[row][i]=='p'){
                capture++;
                break;
            }
        }
        //右
        for (int i = col; i<board[row].length ; i++) {
            if(board[row][i]=='B'){
                break;
            }
            if(board[row][i]=='p'){
                capture++;
                break;
            }
        }
        //上
        for (int i = row; i>=0; i--) {
            if(board[i][col]=='B'){
                break;
            }
            if(board[i][col]=='p'){
                capture++;
                break;
            }
        }
        //下
        for (int i = row; i<board.length; i++) {
            if(board[i][col]=='B'){
                break;
            }
            if(board[i][col]=='p'){
                capture++;
                break;
            }
        }
        return capture;
    }
}
