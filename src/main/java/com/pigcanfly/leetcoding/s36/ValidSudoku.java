package com.pigcanfly.leetcoding.s36;

import java.util.HashSet;

/**
 * @author tobbyquinn
 * @date 2019/11/29
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> rows = new HashSet<>();
        HashSet<String> cols = new HashSet<>();
        HashSet<String> boxes = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                String rowId = board[i][j] + ":" + i;
                String colId = board[i][j] + ":" + j;
                String boxId = board[i][j] + ":" + i / 3 + ":" + j / 3;
                if (rows.contains(rowId) || cols.contains(colId) || boxes.contains(boxId)) {
                    return false;
                }
                rows.add(rowId);
                cols.add(colId);
                boxes.add(boxId);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] arg = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        new ValidSudoku().isValidSudoku(arg);
    }

}
