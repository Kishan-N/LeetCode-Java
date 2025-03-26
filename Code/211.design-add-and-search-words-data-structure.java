/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Design Add and Search Words Data Structure
 */

// @lc code=start
class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord=false;
}

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode cur = root;
        for(char c:word.toCharArray()){
            if(cur.children[c - 'a'] == null)
                cur.children[c - 'a'] = new TrieNode();
            cur = cur.children[c - 'a'];
        }
        cur.endOfWord=true;
    }
    
    public boolean search(String word) {
        return dfs(0,root,word);
    }

    public boolean dfs(int j,TrieNode root,String word){
        TrieNode cur = root;
        for(int i=j;i<word.length();i++){
            char c=word.charAt(i);
            if(c=='.'){
                for(TrieNode child:cur.children){
                    if(child != null  && dfs(i+1,child,word)){
                        return true;
                    }
                }
                return false;
            }
            if(cur.children[c - 'a'] == null)
                return false;
            cur = cur.children[c - 'a'];
        }
        return cur.endOfWord;
    } 
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

