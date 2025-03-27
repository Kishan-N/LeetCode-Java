/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class TrieNode{
    HashMap<Character,TrieNode> children;
    boolean isWord;

    public TrieNode(){
        children = new HashMap<>();
        isWord = false;
    }

    public void addWord(String word){
        TrieNode cur = this;
        for(char c:word.toCharArray()){
            if(cur.children.get(c) == null)
                cur.children.put(c,new TrieNode());
            cur=cur.children.get(c);
        }
        cur.isWord =true;
    }
}

class Solution {
    HashSet<String> res = new HashSet<>();
    boolean[][] visit ;
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode(); 
        for(String word:words){
            root.addWord(word);
        }

        int ROWS=board.length;
        int COLS=board[0].length;
        visit = new boolean[ROWS][COLS];

        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                dfs(r,c,board,root,"");
            }
        }

        return new ArrayList<>(res);
    }

    public void dfs(int r, int c, char[][] board, TrieNode node, String word){

        int ROWS=board.length;
        int COLS=board[0].length;

        if(r<0 || c<0 || r>=ROWS || c>=COLS || visit[r][c] || !node.children.containsKey(board[r][c])){
            return;
        }

        visit[r][c]=true;
        node=node.children.get(board[r][c]);
        word+=board[r][c];
        if(node.isWord){
            res.add(word);
        }

        

        dfs(r+1, c, board, node, word);
        dfs(r-1, c, board, node, word);
        dfs(r, c+1, board, node, word);
        dfs(r, c-1, board, node, word);

        
        visit[r][c]=false;

    }
}
// @lc code=end

