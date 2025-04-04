/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 */

// @lc code=start

class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean enOfWord = false;
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if(cur.children[c - 'a'] == null)
                cur.children[c - 'a'] = new TrieNode();
            cur = cur.children[c - 'a'];
        }
        cur.enOfWord=true;
    }
    
    public boolean search(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if(cur.children[c - 'a'] == null)
                return false;
            cur = cur.children[c - 'a'];
        }
        return cur.enOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char c : prefix.toCharArray()){
            if(cur.children[c - 'a'] == null)
                return false;
            cur = cur.children[c - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

