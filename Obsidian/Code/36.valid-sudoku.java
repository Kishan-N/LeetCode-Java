/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start

import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer,HashSet<Character>> rows = new HashMap<>();
        HashMap<Integer,HashSet<Character>> cols = new HashMap<>();
        HashMap<String,HashSet<Character>> squares = new HashMap<>();
        for(int col=0;col<9;col++){
            for(int row=0;row<9;row++){
                if (board[row][col] == '.') continue;
                String square = row/3 +","+col/3;
                if( rows.computeIfAbsent(row, k -> new HashSet<>()).contains(board[row][col]) || 
                    cols.computeIfAbsent(col, k -> new HashSet<>()).contains(board[row][col]) ||
                    squares.computeIfAbsent(square, k -> new HashSet<>()).contains(board[row][col]))
                    return false;
                rows.get(row).add(board[row][col]);
                cols.get(col).add(board[row][col]);
                squares.get(square).add(board[row][col]);
            }
        }
        return true;
    }
}
// @lc code=end

