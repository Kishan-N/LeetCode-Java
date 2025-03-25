/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {
    HashSet<Integer> col =new HashSet<>();
    HashSet<Integer> negDiag =new HashSet<>();
    HashSet<Integer> posDiag =new HashSet<>();
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] row:board){
            Arrays.fill(row,'.');
        }
        
        build(0,board,n);
        return res;
    }

    public void build(int r, char[][] board, int n) {
        if(r==n){
            ArrayList<String> copy = new ArrayList<>();
            for(char[] row:board){
                copy.add(new String(row));
            }
            res.add(copy);
            return;
        }

        for(int c=0;c<n;c++){
            if(col.contains(c) || negDiag.contains(r-c) || posDiag.contains(r+c)){
                continue;
            }

            col.add(c);
            negDiag.add(r-c);
            posDiag.add(r+c);
            board[r][c] = 'Q';

            build(r+1, board, n);

            col.remove(c);
            negDiag.remove(r-c);
            posDiag.remove(r+c);
            board[r][c] = '.';
        }
        
    }
            
}
// @lc code=end

