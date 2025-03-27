---
created: 2025-03-27
modified: 
completed: true
leetcode-index: 212
link: https://leetcode.com/problems/word-search-ii
difficulty: Hard
tags:
  - leetcode/array
  - leetcode/string
  - leetcode/backtracking
  - leetcode/trie
  - leetcode/matrix
  - programming/practice
  - leetcode/problem
---
# Word Search II

## Question
Given an `m x n` `board` of characters and a list of strings `words`, return *all words on the board*.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 

>[!Example]+ Example 1
>![](https://assets.leetcode.com/uploads/2020/11/07/search1.jpg)
>
>**Input**: `board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]`
>**Output**: `["eat","oath"]
`

>[!Example]+ Example 2
>![](https://assets.leetcode.com/uploads/2020/11/07/search2.jpg)
>
>**Input**: `board = [["a","b"],["c","d"]], words = ["abcb"]`
>**Output**: `[]
`

>[!warning]+ Constraints
>- `m == board.length`
>
>- `n == board[i].length`
>
>- `1 <= m, n <= 12`
>
>- `board[i][j]` is a lowercase English letter.
>
>- `1 <= words.length <= 3 * 10^4`
>
>- `1 <= words[i].length <= 10`
>
>- `words[i]` consists of lowercase English letters.
>
>- All the strings of `words` are unique.
### Hints
>[!Hint]- Hint 1
>You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?

>[!Hint]- Hint 2
>If the current candidate does not exist in all words&#39; prefix, you could stop backtracking immediately. What kind of data structure could answer such query efficiently? Does a hash table work? Why or why not? How about a Trie? If you would like to learn how to implement a basic trie, please work on this problem: Implement Trie (Prefix Tree) first.

---
## Solution

### Intuition
Use a Trie to add all the words.
Maintain an array to check if current letter in the board is visited or not.
Every DFS check if current node is end of word or not and add the word into res if it is.


### Approach
Use the same logic as word search 1 to go through every letter in the board.
While going through each letter in the board we need to check if the letter is present in the Trie which we create to store all the requested input words.

At every letter of the board we check for all the same things in word search 1 but we also check if the letter is part of the prev(current node give to the function until that if) nodes children has current board letter in its hashmap(this is the reason we are not using Array i.e TrieNode[26] here ).

If all check pass we set the current letter as visited using a 2-D boolean visit array.
We cannot change the char to '#' to denote visited like we did in word search 1 because a different word might also use this character.

Next we move from prev node to the current node and also add the current letter to the word String.

Now we check if the current node is the end of a word, and if it is we add the word into the result set(we are using set to not get repeated words).

From here we do a DFS from the current character in all directions and once its is called we backtrack by making removing the current letter in the board from the visit list by marking it back as false.


### Complexity

#### Time complexity


#### Space complexity


### Code
---
```java
class TrieNode{
    HashMap<Character,TrieNode> children;
    boolean isWord;

    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
    }

    public void addWords(String word){
        TrieNode cur = this;
        for(char c:word.toCharArray()){
            if(cur.children.get(c)==null)
                cur.children.put(c,new TrieNode());
            cur=cur.children.get(c);
        }
        cur.isWord = true;
    }
}

class Solution {
    private Set<String> res;
    private boolean[][] visit;

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();        
        for(String word : words){
            root.addWords(word);
        }

        int ROWS = board.length, COLS = board[0].length;
        res = new HashSet<>();
        visit = new boolean[ROWS][COLS];

        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                dfs(r,c,board,root,"");
            }
        }

        return new ArrayList<>(res);
    }

    public void dfs( int r, int c,char[][] board,TrieNode root, String s){
        int ROWS=board.length;
        int COLS=board[0].length;
        if(r<0 || c<0 || r>=ROWS || c >=COLS || visit[r][c] || !root.children.containsKey(board[r][c]))
            return;
                
        visit[r][c] =true;
        root=root.children.get(board[r][c]);
        s+=board[r][c];
        if(root.isWord)
            res.add(s);
        
        dfs(r+1,c,board,root,s);
        dfs(r-1,c,board,root,s);
        dfs(r,c+1,board,root,s);
        dfs(r,c-1,board,root,s);

        visit[r][c] =false;

    }
}

```